package thirdparty.sina.oauth2.friendships.friends.bilateral;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpengsq
 * Date: 13-7-19
 * Time: 下午2:08
 * To change this template use File | Settings | File Templates.
 */
public class BilateralInputTest {
    @Test
    public void testGetUrl() throws Exception {
        BilateralInput input= new BilateralInput(SinaTestKeys.getAccesstoken2(),SinaTestKeys.getSinaUid(),200,1);
        BilateralOutput output = TestBase.call(input,BilateralOutput.class);
        assertTrue(output.getUsers().size() > 0);
    }
}
