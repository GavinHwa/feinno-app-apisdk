package thirdparty.tencent.friends;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-11-4
 * Time: 下午9:26
 */
public class Mutual_listInputTest {
    @Test
    public void test() {
        Mutual_listInput input = new Mutual_listInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(),1,1,"LynxStirp");
        Request request = input.toHttpRequest();
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
            Response response = (Response) future.get();
            Mutual_listOutput output = new Mutual_listOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.getRet() == 0);
        } catch (Exception e) {
        }
    }
}
