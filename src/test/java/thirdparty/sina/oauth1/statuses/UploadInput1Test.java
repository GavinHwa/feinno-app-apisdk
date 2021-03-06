/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth1.statuses.UploadInput1Test.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-10 下午6:41:33
 *
 */
public class UploadInput1Test {

	static byte[] pic = { -119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73,
		72, 68, 82, 0, 0, 0, 32, 0, 0, 0, 32, 8, 3, 0, 0, 0, 68, -92, -118,
		-58, 0, 0, 0, 25, 116, 69, 88, 116, 83, 111, 102, 116, 119, 97,
		114, 101, 0, 65, 100, 111, 98, 101, 32, 73, 109, 97, 103, 101, 82,
		101, 97, 100, 121, 113, -55, 101, 60, 0, 0, 3, 32, 105, 84, 88,
		116, 88, 77, 76, 58, 99, 111, 109, 46, 97, 100, 111, 98, 101, 46,
		120, 109, 112, 0, 0, 0, 0, 0, 60, 63, 120, 112, 97, 99, 107, 101,
		116, 32, 98, 101, 103, 105, 110, 61, 34, -17, -69, -65, 34, 32,
		105, 100, 61, 34, 87, 53, 77, 48, 77, 112, 67, 101, 104, 105, 72,
		122, 114, 101, 83, 122, 78, 84, 99, 122, 107, 99, 57, 100, 34, 63,
		62, 32, 60, 120, 58, 120, 109, 112, 109, 101, 116, 97, 32, 120,
		109, 108, 110, 115, 58, 120, 61, 34, 97, 100, 111, 98, 101, 58,
		110, 115, 58, 109, 101, 116, 97, 47, 34, 32, 120, 58, 120, 109,
		112, 116, 107, 61, 34, 65, 100, 111, 98, 101, 32, 88, 77, 80, 32,
		67, 111, 114, 101, 32, 53, 46, 48, 45, 99, 48, 54, 48, 32, 54, 49,
		46, 49, 51, 52, 55, 55, 55, 44, 32, 50, 48, 49, 48, 47, 48, 50, 47,
		49, 50, 45, 49, 55, 58, 51, 50, 58, 48, 48, 32, 32, 32, 32, 32, 32,
		32, 32, 34, 62, 32, 60, 114, 100, 102, 58, 82, 68, 70, 32, 120,
		109, 108, 110, 115, 58, 114, 100, 102, 61, 34, 104, 116, 116, 112,
		58, 47, 47, 119, 119, 119, 46, 119, 51, 46, 111, 114, 103, 47, 49,
		57, 57, 57, 47, 48, 50, 47, 50, 50, 45, 114, 100, 102, 45, 115,
		121, 110, 116, 97, 120, 45, 110, 115, 35, 34, 62, 32, 60, 114, 100,
		102, 58, 68, 101, 115, 99, 114, 105, 112, 116, 105, 111, 110, 32,
		114, 100, 102, 58, 97, 98, 111, 117, 116, 61, 34, 34, 32, 120, 109,
		108, 110, 115, 58, 120, 109, 112, 61, 34, 104, 116, 116, 112, 58,
		47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47,
		120, 97, 112, 47, 49, 46, 48, 47, 34, 32, 120, 109, 108, 110, 115,
		58, 120, 109, 112, 77, 77, 61, 34, 104, 116, 116, 112, 58, 47, 47,
		110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 120, 97,
		112, 47, 49, 46, 48, 47, 109, 109, 47, 34, 32, 120, 109, 108, 110,
		115, 58, 115, 116, 82, 101, 102, 61, 34, 104, 116, 116, 112, 58,
		47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47,
		120, 97, 112, 47, 49, 46, 48, 47, 115, 84, 121, 112, 101, 47, 82,
		101, 115, 111, 117, 114, 99, 101, 82, 101, 102, 35, 34, 32, 120,
		109, 112, 58, 67, 114, 101, 97, 116, 111, 114, 84, 111, 111, 108,
		61, 34, 65, 100, 111, 98, 101, 32, 80, 104, 111, 116, 111, 115,
		104, 111, 112, 32, 67, 83, 53, 32, 87, 105, 110, 100, 111, 119,
		115, 34, 32, 120, 109, 112, 77, 77, 58, 73, 110, 115, 116, 97, 110,
		99, 101, 73, 68, 61, 34, 120, 109, 112, 46, 105, 105, 100, 58, 52,
		50, 57, 56, 66, 66, 70, 51, 51, 67, 67, 67, 49, 49, 69, 49, 56, 48,
		48, 67, 56, 69, 68, 52, 65, 49, 54, 56, 54, 54, 52, 48, 34, 32,
		120, 109, 112, 77, 77, 58, 68, 111, 99, 117, 109, 101, 110, 116,
		73, 68, 61, 34, 120, 109, 112, 46, 100, 105, 100, 58, 52, 50, 57,
		56, 66, 66, 70, 52, 51, 67, 67, 67, 49, 49, 69, 49, 56, 48, 48, 67,
		56, 69, 68, 52, 65, 49, 54, 56, 54, 54, 52, 48, 34, 62, 32, 60,
		120, 109, 112, 77, 77, 58, 68, 101, 114, 105, 118, 101, 100, 70,
		114, 111, 109, 32, 115, 116, 82, 101, 102, 58, 105, 110, 115, 116,
		97, 110, 99, 101, 73, 68, 61, 34, 120, 109, 112, 46, 105, 105, 100,
		58, 52, 50, 57, 56, 66, 66, 70, 49, 51, 67, 67, 67, 49, 49, 69, 49,
		56, 48, 48, 67, 56, 69, 68, 52, 65, 49, 54, 56, 54, 54, 52, 48, 34,
		32, 115, 116, 82, 101, 102, 58, 100, 111, 99, 117, 109, 101, 110,
		116, 73, 68, 61, 34, 120, 109, 112, 46, 100, 105, 100, 58, 52, 50,
		57, 56, 66, 66, 70, 50, 51, 67, 67, 67, 49, 49, 69, 49, 56, 48, 48,
		67, 56, 69, 68, 52, 65, 49, 54, 56, 54, 54, 52, 48, 34, 47, 62, 32,
		60, 47, 114, 100, 102, 58, 68, 101, 115, 99, 114, 105, 112, 116,
		105, 111, 110, 62, 32, 60, 47, 114, 100, 102, 58, 82, 68, 70, 62,
		32, 60, 47, 120, 58, 120, 109, 112, 109, 101, 116, 97, 62, 32, 60,
		63, 120, 112, 97, 99, 107, 101, 116, 32, 101, 110, 100, 61, 34,
		114, 34, 63, 62, 122, -56, -76, 114, 0, 0, 1, 119, 80, 76, 84, 69,
		-7, -7, -7, -21, -21, -21, -9, -9, -9, -25, -25, -25, -20, -20,
		-20, -23, -23, -23, -108, -108, -108, -107, -107, -107, -10, -10,
		-10, -35, -35, -35, -110, -110, -110, -22, -22, -22, -24, -24, -24,
		-26, -26, -26, -109, -109, -109, -33, -33, -33, -28, -28, -28, 99,
		99, 99, -27, -27, -27, -102, -102, -102, -49, -49, -49, -8, -8, -8,
		-41, -41, -41, -31, -31, -31, -72, -72, -72, -47, -47, -47, -40,
		-40, -40, -46, -46, -46, -30, -30, -30, -43, -43, -43, -34, -34,
		-34, -15, -15, -15, -29, -29, -29, -32, -32, -32, -48, -48, -48,
		-60, -60, -60, -98, -98, -98, -37, -37, -37, -39, -39, -39, -36,
		-36, -36, -113, -113, -113, -42, -42, -42, -38, -38, -38, -105,
		-105, -105, -14, -14, -14, -45, -45, -45, -76, -76, -76, -92, -92,
		-92, -83, -83, -83, -53, -53, -53, -94, -94, -94, -62, -62, -62,
		-69, -69, -69, -90, -90, -90, -111, -111, -111, -101, -101, -101,
		-97, -97, -97, -73, -73, -73, -87, -87, -87, -55, -55, -55, -51,
		-51, -51, 114, 114, 114, -22, -23, -21, -17, -17, -17, -58, -58,
		-58, -77, -77, -77, -96, -96, -96, -74, -74, -74, -79, -79, -79,
		-54, -54, -54, -88, -88, -88, -21, -22, -20, -13, -13, -13, 102,
		102, 102, -93, -93, -93, -66, -66, -66, -56, -56, -56, -44, -44,
		-44, -59, -59, -59, -8, -7, -7, 107, 107, 107, -106, -106, -106,
		119, 119, 119, -81, -81, -81, -65, -65, -65, -78, -78, -78, -20,
		-22, -21, -85, -85, -85, -19, -19, -19, -18, -18, -18, -61, -61,
		-61, 101, 101, 101, -100, -100, -100, -112, -112, -112, 118, 118,
		118, -104, -104, -104, 100, 100, 100, -123, -123, -123, -99, -99,
		-99, -116, -116, -116, -122, -122, -122, -50, -50, -50, -67, -67,
		-67, -82, -82, -82, -80, -80, -80, -16, -16, -16, -86, -86, -86,
		-64, -64, -64, 126, 126, 126, -89, -89, -89, -57, -57, -57, 123,
		123, 123, -52, -52, -52, -128, -128, -128, -70, -70, -70, 121, 121,
		121, -6, -6, -6, -5, -5, -5, -4, -4, -4, -12, -12, -12, -3, -3, -3,
		-11, -11, -11, -2, -2, -2, -21, -20, -20, -1, -1, -1, -1, 78, -101,
		19, 0, 0, 1, -9, 73, 68, 65, 84, 120, -38, -116, -45, 87, -105,
		-102, 64, 0, -122, 97, 112, 4, -92, 35, 16, 64, 4, 65, -20, -67,
		-69, 110, -17, -67, 102, 123, 75, -17, -67, -57, 24, -9, -57, 103,
		48, 71, -116, -71, -32, -8, 94, 126, -13, 28, 46, 24, 64, 54, -49,
		-5, 62, -99, 111, 34, -24, -31, -99, 79, -121, 40, -46, -65, -13,
		-83, 63, 9, -8, -19, -45, -28, 32, -61, 48, 12, -122, -47, 52, 10,
		11, 6, -125, 40, 70, -85, -56, 24, 80, 88, 17, -67, -68, 122, 83,
		-36, -22, -122, 2, 8, -126, 4, -70, 22, 67, 123, -32, 23, 44, -57,
		-38, 122, -118, -116, -37, 44, 6, 31, 64, 51, -30, 98, 72, 100,
		-35, -35, 3, 10, -120, 20, -92, 100, 125, -29, 85, -7, -21, 105,
		115, -71, 90, -1, 28, 16, -58, 65, 14, -44, 40, -30, -2, -44, 74,
		-27, -19, -55, -14, 89, 117, 35, 57, 27, 18, -64, 24, 48, -39, -91,
		7, 28, -57, 77, 85, 102, -86, 23, 31, 118, 58, -60, 117, 79, -64,
		60, -16, 19, 102, -38, -91, -109, -77, -14, -22, 69, -78, -46, 90,
		75, 52, 78, -75, 116, -47, -58, -36, -35, 3, -5, 113, -125, 5, -12,
		-27, 92, -95, -45, 89, 47, 22, 45, 107, 49, 104, -116, -125, 18,
		-49, 27, 2, 75, -41, 56, 73, 74, 108, 13, 94, -124, 58, 2, 63, 96,
		-47, 76, -116, 87, 5, -80, 71, 17, -60, -82, 69, -45, 24, 3, 120,
		-58, -35, 71, 32, -27, 10, 113, -119, -62, -15, -26, 21, 0, 64, 20,
		99, -1, -127, 116, 58, 67, -14, 70, 2, 2, 13, 21, 4, -63, 54, -56,
		17, -8, 14, -117, 40, 74, 26, -66, -55, 6, -123, 115, -85, 64, 85,
		-43, 120, -116, -60, -36, -35, 3, -114, 105, 42, 122, -98, 124,
		-41, -58, -71, -78, 24, -25, 99, 36, -81, 71, -58, -128, 92, -118,
		-102, 57, 61, -1, -78, -115, 19, -45, 44, -103, 33, 99, -87, -23,
		91, 48, 4, -16, -10, 16, 57, -30, 68, 75, 57, 69, 107, -29, 20,
		-15, 52, 43, 105, -51, -75, 100, 33, 1, -9, 127, -128, -20, 68,
		-94, 102, 57, -101, -3, 54, 127, -12, 112, 101, -90, -107, 36, 30,
		105, 67, 112, 15, -26, 56, 115, -14, 11, 89, -98, -43, -114, -73,
		31, -121, 111, 62, 17, 56, -50, -35, 106, 112, 31, -128, 0, 108,
		47, -81, -24, 122, 58, 79, -66, -66, 9, -121, -61, -37, -17, 57,
		-118, 42, 84, 118, -31, -18, -127, 90, -29, 58, 113, 112, -16, 113,
		-3, 11, 60, 15, 31, 19, -16, -26, 119, -22, -58, 16, -124, 96, -42,
		-33, -113, 49, -11, 36, 75, 61, -97, 63, 122, 38, 73, 82, 107, -65,
		7, -9, 1, -24, -7, 52, 25, -24, -6, 4, 1, -118, -8, -3, 121, -16,
		120, 1, -11, -5, -3, -47, -123, 63, 2, 12, 0, 51, -36, 63, 21, -66,
		91, -69, -16, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126 };
	
	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		UploadInput1 input = new UploadInput1(SinaTestKeys.getAccesstoken(),
				SinaTestKeys.getAccessSecret(), SinaTestKeys.getMessage(),
						pic);

        UploadOutput1 output = TestBase.call(input,UploadOutput1.class);
		assertTrue(output.outputOK());
	}

}
