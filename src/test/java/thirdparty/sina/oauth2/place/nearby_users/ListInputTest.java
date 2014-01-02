package thirdparty.sina.oauth2.place.nearby_users;

import org.junit.Test;
import thirdparty.TestBase;

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
    public void test() throws InstantiationException, IllegalAccessException {
        ListInput input = new ListInput(39.93f, 116.46f);
        ListOutput output = TestBase.call(input,ListOutput.class);
        assertNotSame(0, output.getUsers().size());

        input = new ListInput(39.93f, 116.46f, 20, 1);
        output = TestBase.call(input,ListOutput.class);
        assertNotSame(0, output.getUsers().size());

        input = new ListInput(39.93f, 116.46f, 50, 1, 1000, 252432000, 978278400);
        output = TestBase.call(input,ListOutput.class);
        assertNotSame(0, output.getUsers().size());
    }
}
