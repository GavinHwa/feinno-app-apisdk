package thirdparty.sohu.statues.show;

import thirdparty.sohu.SohuTestKeys;
import com.ning.http.client.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-12-16
 * Time: 下午9:36
 */
public class IdInputTest {
    @Test
    public void test(){
        IdInput input = new IdInput(SohuTestKeys
                .accessToken,SohuTestKeys.accessSecret,"10261721073");
        //input.setDebug(true);
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
            IdOutput output = new IdOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
