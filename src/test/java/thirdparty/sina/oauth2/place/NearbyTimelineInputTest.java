package thirdparty.sina.oauth2.place;

import org.junit.Test;
import thirdparty.TestBase;

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
    public void test() throws InstantiationException, IllegalAccessException {

        NearbyTimelineInput input = new NearbyTimelineInput(39.93f,116.46f);
        NearbyTimelineOutput output = TestBase.call(input,NearbyTimelineOutput.class);
            assertNotSame(0,output.getStatuses().size());

        input = new NearbyTimelineInput(39.93f,116.46f,20,1);
        output = TestBase.call(input,NearbyTimelineOutput.class);
        assertNotSame(0,output.getStatuses().size());

        input = new NearbyTimelineInput(39.93f,116.46f,20,1,1000);
        output = TestBase.call(input,NearbyTimelineOutput.class);
        assertNotSame(0,output.getStatuses().size());

        input = new NearbyTimelineInput(39.93f,116.46f,1374119172L,20,1,1000);
        output = TestBase.call(input,NearbyTimelineOutput.class);
        assertNotSame(0,output.getStatuses().size());
    }
}
