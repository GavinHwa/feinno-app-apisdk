package thirdparty.sina.oauth2.friendships.friends.bilateral;

import thirdparty.sina.SinaTestKeys;
import com.ning.http.client.*;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpengsq
 * Date: 13-7-19
 * Time: 下午2:08
 * To change this template use File | Settings | File Templates.
 */
public class BilateralInputTest {
    @Test
    public void testGetUrl() throws Exception {
        BilateralInput input= new BilateralInput(SinaTestKeys.getAccesstoken2(),SinaTestKeys.getSinaUid(),200,1);
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
            BilateralOutput output = new BilateralOutput();
            output.fromHttpResponse(response, null);
        } catch (Exception e) {
        }
    }
}
