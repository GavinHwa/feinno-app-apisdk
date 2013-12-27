package thirdparty.sohu.statues;

import thirdparty.sina.SinaTestKeys;
import thirdparty.sohu.SohuTestKeys;
import com.ning.http.client.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-12-16
 * Time: 下午10:38
 */
public class UpdateInputTest {
    @Test
    public void test(){
        UpdateInput input = new UpdateInput(SohuTestKeys
                .accessToken,SohuTestKeys.accessSecret, SinaTestKeys.getMessage());
//        input.setDebug(true);
        Request request = input.toHttpRequest();
        AsyncHttpClient httpClient = new AsyncHttpClient();

        try {
            ListenableFuture<Response> future = httpClient.executeRequest(request, new AsyncCompletionHandler<Response>() {

                @Override
                public Response onCompleted(Response response) throws Exception {
                    return response;
                }
            });

            Response response = future.get();

            assertNotNull(response.getResponseBody());
            UpdateOutput output = new UpdateOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
