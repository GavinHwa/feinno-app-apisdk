package thirdparty.sina.oauth1.Users;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-17
 * Time: 下午6:20
 * To change this template use File | Settings | File Templates.
 */
public class ShowInput1Test {
    @Test
    public void testGetUrl() throws Exception {
        ShowInput1 input1 = new ShowInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),Long.parseLong(SinaTestKeys.getSinaUid()));
        Request request = input1.toHttpRequest();
        AsyncHttpClient httpClient = new AsyncHttpClient();
        try {
            ListenableFuture<Object> future = httpClient.executeRequest(
                    request, new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response)
                        throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            ShowOutput1 output = new ShowOutput1();
            output.fromHttpResponse(response, null);
            assertEquals(output.getScreen_name(),"看我在测试");
            assertEquals(output.getId(),SinaTestKeys.getSinaUid());
        } catch (Exception e) {
        }

        input1 = new ShowInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),"看我在测试");
        request = input1.toHttpRequest();
        try {
            ListenableFuture<Object> future = httpClient.executeRequest(
                    request, new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response)
                        throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            ShowOutput1 output = new ShowOutput1();
            output.fromHttpResponse(response, null);
            assertEquals(output.getScreen_name(),"看我在测试");
            assertEquals(output.getId(),SinaTestKeys.getSinaUid());
        } catch (Exception e) {
        }
    }
}
