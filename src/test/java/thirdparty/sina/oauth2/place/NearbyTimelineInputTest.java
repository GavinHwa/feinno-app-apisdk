package thirdparty.sina.oauth2.place;

import com.ning.http.client.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-7-11
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class NearbyTimelineInputTest {
    @Test
    public void test() {

        AsyncHttpClient httpClient = new AsyncHttpClient();
        NearbyTimelineInput input = new NearbyTimelineInput(39.93f,116.46f);
        Request request = input.toHttpRequest();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            NearbyTimelineOutput output = new NearbyTimelineOutput();
            output.fromHttpResponse(response, null);
            assertNotSame(0,output.getStatuses().size());
        } catch (Exception e) {
        }

        input = new NearbyTimelineInput(39.93f,116.46f,20,1);
        request = input.toHttpRequest();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            NearbyTimelineOutput output = new NearbyTimelineOutput();
            output.fromHttpResponse(response, null);
            assertNotSame(0,output.getStatuses().size());
        } catch (Exception e) {
        }

        input = new NearbyTimelineInput(39.93f,116.46f,20,1,1000);
        request = input.toHttpRequest();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            NearbyTimelineOutput output = new NearbyTimelineOutput();
            output.fromHttpResponse(response, null);
            assertNotSame(0,output.getStatuses().size());
        } catch (Exception e) {
        }

        input = new NearbyTimelineInput(39.93f,116.46f,1374119172L,20,1,1000);
        request = input.toHttpRequest();

        try {
            ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

                @Override
                public Object onCompleted(Response response) throws Exception {
                    return response;
                }
            });
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            NearbyTimelineOutput output = new NearbyTimelineOutput();
            output.fromHttpResponse(response, null);
            if (null != output.getStatuses()){
                assertNotSame(0,output.getStatuses().size());
            }
        } catch (Exception e) {
        }
    }
}
