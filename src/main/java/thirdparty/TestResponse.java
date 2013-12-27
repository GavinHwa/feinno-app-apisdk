package thirdparty;

import com.ning.http.client.Cookie;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;
import com.ning.http.client.Response;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.List;

/**
 * 给单元测试新建的测试类
 * @author	shangrenpeng
 * @date	2012-10-18 上午10:28:50
 *
 */
public class TestResponse implements Response{
		private String ans = null;
		private int returnCode;
		
		/**
		 * @param i
		 */
		public TestResponse(String json) {
			ans = json;
			returnCode = 200;
		}
		
		public TestResponse(String json, int returnCode) {
			ans = json;
			this.returnCode = returnCode;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getStatusCode()
		 */
		@Override
		public int getStatusCode() {
			
			return returnCode;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getStatusText()
		 */
		@Override
		public String getStatusText() {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBodyAsBytes()
		 */
		@Override
		public byte[] getResponseBodyAsBytes() throws IOException {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBodyAsStream()
		 */
		@Override
		public InputStream getResponseBodyAsStream() throws IOException {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBodyExcerpt(int, java.lang.String)
		 */
		@Override
		public String getResponseBodyExcerpt(int maxLength, String charset)
				throws IOException {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBody(java.lang.String)
		 */
		@Override
		public String getResponseBody(String charset) throws IOException {
			return ans;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBodyExcerpt(int)
		 */
		@Override
		public String getResponseBodyExcerpt(int maxLength) throws IOException {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getResponseBody()
		 */
		@Override
		public String getResponseBody() throws IOException {
			return ans;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getUri()
		 */
		@Override
		public URI getUri() throws MalformedURLException {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getContentType()
		 */
		@Override
		public String getContentType() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getHeader(java.lang.String)
		 */
		@Override
		public String getHeader(String name) {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getHeaders(java.lang.String)
		 */
		@Override
		public List<String> getHeaders(String name) {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getHeaders()
		 */
		@Override
		public FluentCaseInsensitiveStringsMap getHeaders() {
			
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#isRedirected()
		 */
		@Override
		public boolean isRedirected() {
			return false;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#getCookies()
		 */
		@Override
		public List<Cookie> getCookies() {
			return null;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#hasResponseStatus()
		 */
		@Override
		public boolean hasResponseStatus() {
			return false;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#hasResponseHeaders()
		 */
		@Override
		public boolean hasResponseHeaders() {
			return false;
		}

		/* (non-Javadoc)
		 * @see com.ning.http.client.Response#hasResponseBody()
		 */
		@Override
		public boolean hasResponseBody() {
			return false;
		}
		
	}