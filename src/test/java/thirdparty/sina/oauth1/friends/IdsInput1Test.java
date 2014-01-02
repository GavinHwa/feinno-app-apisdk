package thirdparty.sina.oauth1.friends;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpeng
 * Date: 13-6-6
 * Time: 下午11:32
 * To change this template use File | Settings | File Templates.
 */
public class IdsInput1Test {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        IdsInput1 input = new IdsInput1(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret());
        IdsOutput1 output = TestBase.call(input, IdsOutput1.class);
        assertEquals(output.getIds().size(), 4);
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        IdsInput1 input = new IdsInput1(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret(), 1, 1);
        IdsOutput1 output = TestBase.call(input, IdsOutput1.class);
        assertEquals(output.getIds().size(), 1);
        assertEquals(output.getNext_cursor(), 2);
        assertEquals(output.getPrevious_cursor(), 1);
    }
}
