/**
 * 
 */
package thirdparty.sina;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.app.sync.spi.sina.SinaEmotionTransformerTest.java
 *
 * date		| author	| version	|  
 * 2012-12-7	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-7 上午10:51:42
 *
 */
public class SinaEmotionTransformerTest {

	private static final String ourEmotions[] = {"[/大笑]","[/微笑]","[/汗]","[/悲伤]","[/愤怒]","[/鄙视]","[/睡觉]","[/抓狂]","[/OK]","[/强]"};
	private static final String sinaEmotions[] = {"[哈哈]","[呵呵]","[汗]","[泪]","[怒]","[鄙视]","[困]","[抓狂]","[ok]","[good]"};
	
	@Test
	public void test() {
		for (int i = 0; i < ourEmotions.length;i ++) {
			assertEquals(sinaEmotions[i], SinaEmotionTransformer.transform2Sina(ourEmotions[i]));
		}
		
		for (int i = 0; i < sinaEmotions.length;i ++) {
			assertEquals(ourEmotions[i], SinaEmotionTransformer.transform2Our(sinaEmotions[i]));
		}
	}

}
