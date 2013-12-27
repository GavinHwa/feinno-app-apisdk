package thirdparty.sina.oauth2.place.nearby_users;

import com.ning.http.client.*;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: TonyChiu
 * Date: 13-8-19
 * Time: 下午7:08
 * To change this template use File | Settings | File Templates.
 */
public class ListInputTest {
    @Test
    public void test() {

        AsyncHttpClient httpClient = new AsyncHttpClient();
        ListInput input = new ListInput(39.93f, 116.46f);
        Request request = input.toHttpRequest();

//        try {
//            ListenableFuture<Object> future = httpClient.executeRequest(request, new AsyncCompletionHandler<Object>() {
//
//                @Override
//                public Object onCompleted(Response response) throws Exception {
//                    return response;
//                }
//            });
//            Response response = (Response) future.get();
//            assertNotNull(response.getResponseBody());
//            ListOutput output = new ListOutput();
//            output.fromHttpResponse(response, null);
//            assertNotSame(0, output.getUsers().size());
//        } catch (Exception e) {
//        }
//
//        input = new ListInput(39.93f, 116.46f, 20, 1);
//        request = input.toHttpRequest();
//
//        try {
//            ListenableFuture<Object> future = httpClient.executeRequest(request, new AsyncCompletionHandler<Object>() {
//
//                @Override
//                public Object onCompleted(Response response) throws Exception {
//                    return response;
//                }
//            });
//            Response response = (Response) future.get();
//            assertNotNull(response.getResponseBody());
//            ListOutput output = new ListOutput();
//            output.fromHttpResponse(response, null);
//            assertNotSame(0, output.getUsers().size());
//        } catch (Exception e) {
//        }

        input = new ListInput(39.93f, 116.46f, 50, 1, 1000, 252432000, 978278400);
        request = input.toHttpRequest();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request, new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response) future.get();
            assertNotNull(response.getResponseBody());
            ListOutput output = new ListOutput();
            output.fromHttpResponse(response, null);
            assertNotSame(0, output.getUsers().size());
        } catch (Exception e) {
        }
    }
}
