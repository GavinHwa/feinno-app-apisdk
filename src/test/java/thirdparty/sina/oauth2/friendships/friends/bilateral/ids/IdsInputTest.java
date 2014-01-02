package thirdparty.sina.oauth2.friendships.friends.bilateral.ids;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-7
 * Time: 上午12:16
 * To change this template use File | Settings | File Templates.
 */
public class IdsInputTest {
    @Test
    public void testGetUrl() throws Exception {
        IdsInput input= new IdsInput(SinaTestKeys.getAccesstoken2(),SinaTestKeys.getSinaUid());
        IdsOutput output = TestBase.call(input,IdsOutput.class);
        assertTrue(output.getIds().size() > 0);
    }
}
