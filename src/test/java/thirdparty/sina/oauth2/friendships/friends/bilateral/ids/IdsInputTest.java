package thirdparty.sina.oauth2.friendships.friends.bilateral.ids;

import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.shorturl.ExpandOutput;
import com.ning.http.client.*;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-7
 * Time: 上午12:16
 * To change this template use File | Settings | File Templates.
 */
public class IdsInputTest {
    @Test
    public void testGetUrl() throws Exception {
        IdsInput input= new IdsInput(SinaTestKeys.getAccesstoken2(),SinaTestKeys.getSinaUid());
        Request request = input.toHttpRequest();
        AsyncHttpClient httpClient = new AsyncHttpClient();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            IdsOutput output = new IdsOutput();
            output.fromHttpResponse(response, null);
            assertEquals(output.getIds().size(),output.getTotal_number());
        } catch (Exception e) {
        }
    }
}
