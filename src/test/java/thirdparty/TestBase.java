package thirdparty;

import com.ning.http.client.*;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-12-25
 * Time: 下午10:22
 */
public class TestBase {
    public static <T extends Output> T call(Input input, Class<T> c) throws IllegalAccessException, InstantiationException {
        Request request = input.toHttpRequest();
        AsyncHttpClient httpClient = new AsyncHttpClient();
        T output = c.newInstance();
        try {
            ListenableFuture<Response> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Response>() {

                @Override
                public Response onCompleted(Response response) throws Exception {
                    return response;
                }
            });

            Response response = future.get();

            output.fromHttpResponse(response, null);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            return output;
        }
    }
}
