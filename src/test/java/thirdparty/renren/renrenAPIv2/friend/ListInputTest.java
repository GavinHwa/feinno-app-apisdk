package thirdparty.renren.renrenAPIv2.friend;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-6
 * Time: 下午4:15
 * To change this template use File | Settings | File Templates.
 */
public class ListInputTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        ListInput input = new ListInput(
                RenrenTestKeys.getAccessToken(),1);
        ListOutput output = TestBase.call(input,ListOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertTrue(output.getResponse().size() != 0);
    }
}
