package thirdparty.sohu.statues;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sohu.SohuTestKeys;
import thirdparty.sohu.statues.FriendsTimelineInput;
import thirdparty.sohu.statues.FriendsTimelineOutput;

import static org.junit.Assert.*;

/**
 * @author : shangrenpengsq
 *         Date: 13-12-2
 *         Time: 下午5:21
 * @describe :
 * <p/>
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */
public class FriendsTimelineInputTest {
    @Test
    public void test(){
        FriendsTimelineInput input = new FriendsTimelineInput(SohuTestKeys
                .accessToken,SohuTestKeys.accessSecret,1,10);
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
            FriendsTimelineOutput output = new FriendsTimelineOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
