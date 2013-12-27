package thirdparty.sina.oauth1.friends;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-6
 * Time: 下午11:32
 * To change this template use File | Settings | File Templates.
 */
public class IdsInput1Test {
    @Test
    public void test1() {
        IdsInput1 input = new IdsInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret());
        //		input.setDebug(true);
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
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            IdsOutput1 output = new IdsOutput1();
            output.fromHttpResponse(response, null);
            assertEquals(output.getIds().size(),4);

        } catch (Exception e) {
        }


        //		input.setDebug(true);
//        request = input.toHttpRequest();
    }
        @Test
        public void test2() {
            IdsInput1 input = new IdsInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),1,1);
            //		input.setDebug(true);
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
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            IdsOutput1 output = new IdsOutput1();
            output.fromHttpResponse(response, null);
            assertEquals(output.getIds().size(),1);
            assertEquals(output.getNext_cursor(),2);
            assertEquals(output.getPrevious_cursor(),1);

        } catch (Exception e) {
        }
    }
}
