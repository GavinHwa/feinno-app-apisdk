package thirdparty.renren.oauth1.feed;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-12-26
 * Time: 下午9:47
 */
public class PublishFeedInputTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        PublishFeedInput input = new PublishFeedInput(RenrenTestKeys.getAccessToken(),RenrenTestKeys.getMessage(),RenrenTestKeys.getUserid());
        PublishFeedOutput output = TestBase.call(input,PublishFeedOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertNotSame(0,output.getPost_id());
    }
}
