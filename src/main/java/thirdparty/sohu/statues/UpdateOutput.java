package thirdparty.sohu.statues;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectReader;
import com.ning.http.client.Response;
import thirdparty.sohu.SohuOutput;
import thirdparty.sohu.Status;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午2:54
 * @describe :
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class UpdateOutput extends SohuOutput {
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    final static TypeReference<Status> type = new
            TypeReference<Status>() {
    };

    @Override
    public void fromHttpResponse(Response response, Throwable throwable) {
        if (throwable != null){
            LOGGER.error(throwable.getMessage());
            return;
        }
        if (response.getStatusCode() == 200) {
            try {
                parseResponse(response);
            } catch (Exception e) {
                LOGGER.error(e.getMessage());
                error = e.getMessage();
                return;
            }
        } else {
            try {
                ObjectReader reader = mapper.readerForUpdating(this);
                reader.readValue(response.getResponseBody("UTF-8"));
                return;
            } catch (Exception e) {
                LOGGER.error(response.getStatusCode() + "\n" + e.getMessage());
                code = 500;
                return;
            }
        }
    }

    /**
     * 解析返回的内容，默认已经200返回了。如果解析不了，那么this中只有error对象不为空
     *
     * @param response
     * @throws java.io.IOException
     */
    private void parseResponse(Response response) throws Exception {
        String content;
        if ((content = response.getResponseBody("UTF-8")) != null) {
            try {
                status = (mapper.readValue(content, type));
            } catch (JsonMappingException e) {//正常的status解析不出来，估计就是error返回了，解析一下error吧！
                ObjectReader reader = mapper.readerForUpdating(this);
                reader.readValue(content);
            }
        }
    }
}
