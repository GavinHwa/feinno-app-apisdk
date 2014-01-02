package thirdparty.sina.oauth1.Users;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-17
 * Time: 下午6:20
 * To change this template use File | Settings | File Templates.
 */
public class ShowInput1Test {
    @Test
    public void testGetUrl() throws Exception {
        ShowInput1 input1 = new ShowInput1(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret(),
                Long.parseLong(SinaTestKeys.getSinaUid()));
        ShowOutput1 output = TestBase.call(input1, ShowOutput1.class);
        assertEquals(output.getScreen_name(), "看我在测试");
        assertEquals(output.getId(), SinaTestKeys.getSinaUid());

        input1 = new ShowInput1(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret(), "看我在测试");
        output = TestBase.call(input1, ShowOutput1.class);
        assertEquals(output.getScreen_name(), "看我在测试");
        assertEquals(output.getId(), SinaTestKeys.getSinaUid());
    }
}
