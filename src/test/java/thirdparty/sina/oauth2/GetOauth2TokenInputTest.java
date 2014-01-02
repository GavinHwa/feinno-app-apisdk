/**
 *
 */
package thirdparty.sina.oauth2;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth1.SinaOauth1Input;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.GetOauth2TokenInputTest.java
 *
 * date		| author	| version	|  
 * 2012-10-18	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-10-18 下午8:19:51
 */
public class GetOauth2TokenInputTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        SinaOauth1Input input = new GetOauth2TokenInput(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret());
        GetOauth2TokenOutput output = TestBase.call(input, GetOauth2TokenOutput.class);
        assertNotNull(output.getAccess_token());
        assertNotNull(output.getRefresh_token());
    }

}
