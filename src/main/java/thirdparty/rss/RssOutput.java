/**
 * 
 */
package thirdparty.rss;

import com.feinno.DateUtils;
import com.feinno.HtmlHelper;
import com.feinno.StringUtils;
import com.ning.http.client.Response;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import thirdparty.Output;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.rss.RssOutput.java
 *
 * date		| author	| version	|  
 * 2012-11-27	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-11-27 下午1:47:33
 *
 */
public class RssOutput extends Output {

	protected List<RssFeed> rssFeeds = new ArrayList<RssFeed>();
	private String itemXpath;
	private String titleSign;
	private String pubDateSign;
	private String contentSign;
	private FetchContext fetchContext;
	private Object page;
	
	public RssOutput(FetchContext fetchContext,Object page){
		this.fetchContext = fetchContext;
		this.itemXpath = fetchContext.getItemXpath();
		this.titleSign = fetchContext.getTitleXpath();
		this.contentSign = fetchContext.getTextXpath();
		this.pubDateSign = fetchContext.getPubDateXpath();
		this.setPage(page);
	}
	
	public RssOutput(String itemXpath,String titleSign,String contentSign,String pubDateSign){
		this.itemXpath = itemXpath;
		this.titleSign = titleSign;
		this.contentSign = contentSign;
		this.pubDateSign = pubDateSign;
	}
	
	/**
	 * @return the rssFeeds
	 */
	public List<RssFeed> getRssFeeds() {
		return rssFeeds;
	}

	/**
	 * @param rssFeeds the rssFeeds to set
	 */
	public void setRssFeeds(List<RssFeed> rssFeeds) {
		this.rssFeeds = rssFeeds;
	}

	/**
	 * @return the itemXpath
	 */
	public String getItemXpath() {
		return itemXpath;
	}

	/**
	 * @param itemXpath the itemXpath to set
	 */
	public void setItemXpath(String itemXpath) {
		this.itemXpath = itemXpath;
	}

	/**
	 * @return the titleSign
	 */
	public String getTitleSign() {
		return titleSign;
	}

	/**
	 * @param titleSign the titleSign to set
	 */
	public void setTitleSign(String titleSign) {
		this.titleSign = titleSign;
	}

	/**
	 * @return the pubDateSign
	 */
	public String getPubDateSign() {
		return pubDateSign;
	}

	/**
	 * @param pubDateSign the pubDateSign to set
	 */
	public void setPubDateSign(String pubDateSign) {
		this.pubDateSign = pubDateSign;
	}

	/**
	 * @return the contentSign
	 */
	public String getContentSign() {
		return contentSign;
	}

	/**
	 * @param contentSign the contentSign to set
	 */
	public void setContentSign(String contentSign) {
		this.contentSign = contentSign;
	}

	/* (non-Javadoc)
	 * @see com.feinno.message.HttpConvertibleOutput#fromHttpResponse(com.ning.http.client.Response, java.lang.Throwable)
	 */
	@Override
	public void fromHttpResponse(Response response, Throwable throwable) {
		if (throwable != null){
			return;
		}
		InputStream in = null;
		try {
			if (!urlHasBlankLine(response.getUri().toASCIIString())) {
				in = response.getResponseBodyAsStream();
			} else {
				CharSequence xmlString = getRSSContent(response);
				xmlString = new StringBuilder(xmlString.toString().replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", ""));
				
//				in = new ByteArrayInputStream(UTF8CHARSET.encode(CharBuffer.wrap(xmlString)).array());
				in = new ByteArrayInputStream(xmlString.toString().getBytes());
			}

			try {
				DocumentBuilderFactory domFactory = DocumentBuilderFactory
						.newInstance();
				domFactory.setNamespaceAware(false); // 不去识别命名空间了
				DocumentBuilder builder = domFactory.newDocumentBuilder();

				Document doc = builder.parse(in);

				XPathFactory factory = XPathFactory.newInstance();
				XPath xpath = factory.newXPath();
				XPathExpression expr;

				expr = xpath.compile(getItemXpath());
				Object result = expr.evaluate(doc, XPathConstants.NODESET);
				NodeList nodes = (NodeList) result;

				processItems(response.getUri().toASCIIString(), titleSign, pubDateSign, contentSign, rssFeeds,
						nodes, processors);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}finally {
				in.close();
			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#outputOK()
	 */
	@Override
	public boolean outputOK() {
		return true;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#needRetry()
	 */
	@Override
	public boolean needRetry() {
		return false;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#needLog()
	 */
	@Override
	public boolean needLog() {
		return false;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#logError()
	 */
	@Override
	public void logError() {
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#needUserKnow()
	 */
	@Override
	public boolean needUserKnow() {
		return false;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Output#letUserKnow()
	 */
	@Override
	public void letUserKnow() {
	}

	/**
	 * 处理一个items的list
	 * 
	 * @param rssUrl
	 * @param titleSign
	 * @param pubDateSign
	 * @param contentSign
	 * @param feedList
	 * @param nodes
	 * @param processors
	 */
	private static void processItems(String rssUrl, String titleSign,
			String pubDateSign, String contentSign, List<RssFeed> feedList,
			NodeList nodes, RssContentProcessor[] processors) {
		for (int i = 0; i < nodes.getLength(); i++) {
			RssFeed feed = processOneItem(titleSign, pubDateSign, contentSign,
					nodes.item(i).getChildNodes());
			for (RssContentProcessor processor : processors) {
				if (processor.needProcess(rssUrl)) {
					feed.setContent_encoded(processor.process(feed));
				}
			}

			List<String> SrcString = HtmlHelper.getImgsSrcSafe(feed
                    .getContent_encoded());
			if (SrcString.size() != 0) {
				String picSrcString = SrcString.get(0);
				feed.setPic_src(picSrcString);
			}
			if (validateFeed(feed)) {
				feedList.add(feed);
			}
		}
	}

	/**
	 * 验证一个feed是否是合法的
	 * 
	 * @param feed
	 * @return
	 */
	private static boolean validateFeed(RssFeed feed) {
		if (feed != null) {
			if (StringUtils.isNotEmpty(feed.getContent_encoded().trim())) {
				if (StringUtils.isNotEmpty(feed.getPubDate().trim())) {
					if (StringUtils.isNotEmpty(feed.getTitle().trim())) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * 处理一个item，并且返回一个站内的feed
	 * 
	 * @param titleSign
	 * @param pubDateSign
	 * @param contentSign
	 * @param nodes
     */
	private static RssFeed processOneItem(String titleSign, String pubDateSign,
			String contentSign, NodeList nodes) {
		RssFeed feed = new RssFeed();

		for (int i = 0; i < nodes.getLength(); i++) {
			if (nodes.item(i).getNodeName().toLowerCase().equals(titleSign)) {
				feed.setTitle(nodes.item(i).getTextContent());
			}
			if (nodes.item(i).getNodeName().toLowerCase().equals(pubDateSign)) {
				feed.setPubDate(nodes.item(i).getTextContent());
			}
			if (nodes.item(i).getNodeName().toLowerCase().equals(contentSign)) {
				feed.setContent_encoded(nodes.item(i).getTextContent());
			}
			if (nodes.item(i).getNodeName().toLowerCase().equals("link")) {
				feed.setLink(nodes.item(i).getTextContent());
			}
			if (nodes.item(i).getNodeName().toLowerCase().equals("fetionlink")) {
				feed.setFetionLink(nodes.item(i).getTextContent());
			}
		}

		return feed;
	}

	/**
	 * 如果rss开头第一行空行，添加到这里，会把空行去掉的
	 * 
	 * @param rssUrl
	 * @return
	 */
	private static boolean urlHasBlankLine(String rssUrl) {
		if (rssUrl.toLowerCase().contains("http://kxt.fm/?feed=rss2") 
				|| rssUrl.toLowerCase().contains("http://www.fqpai.com/feed")
				|| rssUrl.toLowerCase().contains("http://feed.qiushibaike.com/rss")
				) {
			return true;
		}
		return false;
	}
	
	public static CharSequence getRSSContent(Response response) throws IOException {

		
		String charset = getCharset(response.getContentType());
		InputStream in = null;
		BufferedReader rd = null;
		try{
			in = response.getResponseBodyAsStream();

			rd = new BufferedReader(new InputStreamReader(in
					, charset));

			String tempLine = rd.readLine();
			StringBuilder temp = new StringBuilder();
			while (tempLine != null) {
				temp.append(tempLine);
				temp.append(" ");
				tempLine = rd.readLine();
			}
			return clearBlank(temp);
		}finally{
			rd.close();
			in.close();
		}
	}

	/**
	 * 清除开头的空行
	 * 
	 * @param buffer
	 * @return
	 */
	private static CharSequence clearBlank(StringBuilder buffer) {
		if (buffer.indexOf("<?xml") > 0) {
			buffer.delete(0, buffer.indexOf("<?xml"));
			return buffer;
		}
		return buffer;
	}

	/**
	 * 获取头中的编码格式
	 * 
	 * @param contentType
	 * @return
	 */
	private static String getCharset(String contentType) {
		String charset = null;
		if (contentType == null) {
			return "UTF-8";
		}
		if (contentType.indexOf("charset=") >= 0) {
			charset = contentType.substring(contentType.indexOf("charset="));
			if (charset.indexOf(";") >= 0) {
				return getCharsetValue(charset.substring(0,
						charset.indexOf(";")));
			} else {
				return getCharsetValue(charset);
			}
		}
		return "UTF-8";
	}

	/**
	 * 获得一个标签中的字符,适用于xxx=xxx;
	 * 
	 * @param substring
	 * @return
	 */
	private static String getCharsetValue(String substring) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < substring.length(); i++) {
			if (substring.charAt(i) == '=') {
				for (int j = i + 1; j < substring.length(); j++) {
					if (substring.charAt(j) == ';') {
						break;
					}
					sBuilder.append(substring.charAt(j));
				}
				break;
			}
		}
		return sBuilder.toString();
	}
	
	public FetchContext getFetchContext() {
		return fetchContext;
	}

	public void setFetchContext(FetchContext fetchContext) {
		this.fetchContext = fetchContext;
	}

	public Object getPage() {
		return page;
	}

	public void setPage(Object page) {
		this.page = page;
	}

	private static RssContentProcessor[] processors = { new PubdateProcessor(),
			new JSProcessor(), new LinkProcessor(), new FanqieProcessor(),
			new Kr36Processor(), new TuniuProcessor(),
			new SourceLinkProcessor(), new QiubaiProcessor() };// 最后的实现依赖于填写的顺序，所以顺序要小心哦
	
	
}

interface RssContentProcessor {
	/**
	 * 判断是否需要url的处理
	 * 
	 * @param url
	 * @return
	 */
	boolean needProcess(String url);

	/**
	 * 针对该网站处理并返回处理结果,需要应对content是null的情况. 但是不能返回null
	 * 
	 * @param feed
	 * @return
	 */
	String process(RssFeed feed);
}

class NomalizeRss{

	/**
	 * @param content
	 * @return
	 */
	protected String normalize(String content) {
		content = cleanNoScripts(content);
		content = HtmlHelper.cleanHtmlAndBuildImg(content);
		content = combineBlankLines(content);
		if (StringUtils.isEmpty(content.replace("\r\n", ""))){
			return "";
		}
		content = addSpace(content);
		return "&#12288;&#12288;" + content;
	}

	private static Pattern noscriptPattern = Pattern.compile("\\<noscript.*?\\/noscript>",Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	/**
	 * @param content
	 * @return
	 */
	private String cleanNoScripts(String content) {
		Matcher m = noscriptPattern.matcher(content);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/**
	 * @param content
	 * @return
	 */
	private String addSpace(String content) {
		return content.replace("\n", "<br /><br />&#12288;&#12288;");
	}

	private static Pattern blankPattern = Pattern.compile("\\s+");
	/**
	 * @param content
	 * @return
	 */
	private String combineBlankLines(String content) {
		Matcher m = blankPattern.matcher(content);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			if (m.group().contains("\n")){
				m.appendReplacement(sb, "\r\n");
			}else{
				m.appendReplacement(sb, " ");
			}
		}
		m.appendTail(sb);
		return sb.toString();
	}
}

final class PubdateProcessor implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProcessor#needProcess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		return true;// 所有的都需要处理发布时间啊
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProcessor#process
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getPubDate() != null) {
			feed.setRealPubDate(DateUtils.tryParseDate2Long(feed.getPubDate()));
			return HtmlHelper.cleanMultiLineJS(feed.getContent_encoded());
		}
		return "";
	}

}

final class JSProcessor implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProcessor#needProcess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		return true;// 所有的content都需要清除js代码哦！
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProcessor#process
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return HtmlHelper.cleanMultiLineJS(feed.getContent_encoded());
		}
		return "";
	}

}

final class LinkProcessor implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RssContentProcessor#needProcess(java.lang.String
	 * )
	 */
	@Override
	public boolean needProcess(String url) {
		return true;// 全部a标签都要变成新窗口打开的类型
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RssContentProcessor#process(java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return feed.getContent_encoded().replace("<a ",
					"<a target=\"_blank\" ");
		}
		return "";
	}

}

final class FanqieProcessor extends NomalizeRss implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#needProccess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		if (url.equals("http://www.fqpai.com/feed")) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#proccess
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return normalize(processImg(feed.getContent_encoded()));
		}
		return "";
	}

	/**
	 * 针对番茄网处理一下img，因为真正的图片在data-href里面
	 * 
	 * @param summary
	 * @return
	 */
	private String processImg(String summary) {
		if (summary != null) {
			return summary
					.replaceAll(
							"src=\"http://www.fqpai.com/wp-content/plugins/bj-lazy-load/img/placeholder.gif\"",
							"").replaceAll("data-href", "src");
		}
		return "";
	}
}

final class Kr36Processor extends NomalizeRss implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#needProccess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		if (url.contains("http://www.36kr.com/")) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#proccess
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return normalize(feed.getContent_encoded());
		}
		return "";
	}
}

final class TuniuProcessor implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#needProccess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		if (url.equals(
				"http://bbs.tuniu.com/output/forum_rss_64.xml")) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#proccess
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return processHref(feed.getContent_encoded());
		}
		return "";
	}

	/**
	 * 针对kxt网处理一下广告
	 * 
	 * @param summary
	 * @return
	 */
	private String processHref(String summary) {
		if (summary != null) {
			return summary.replaceAll("p=11651&cmpid=union_11651",
					"p=13437&cmpid=mkt_06025101");
		}
		return "";
	}
}

final class SourceLinkProcessor implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#needProccess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		if (url.equals("http://www.xingzuowu.com/getArticle.php")) {
			return true;
		}
		if (url.equals("http://kxt.fm/?feed=rss2")) {
			return true;
		}
		if (url.contains("55bbs.com")) {
			return true;
		}
		if (url.equals("http: // www.m1905.com/rss-p-rssid-203-bd-11.xml")) {
			return true;
		}
		if (url.equals("http://rss.cnfol.com/news.xml")) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#proccess
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (StringUtils.isNotEmpty(feed.getContent_encoded().trim())) {
			return feed.getContent_encoded()
					+ "<p><a target=\"_blank\" href=\"" + feed.getLink()
					+ "\">查看原文</a></p>";
		}
		return "";
	}
}

final class QiubaiProcessor extends NomalizeRss implements RssContentProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#needProccess
	 * (java.lang.String)
	 */
	@Override
	public boolean needProcess(String url) {
		if (url.contains("http://feed.qiushibaike.com/rss")) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.feinno.app.sync.page.RSSfeedExchanger.RssContentProccessor#proccess
	 * (java.lang.String)
	 */
	@Override
	public String process(RssFeed feed) {
		if (feed.getContent_encoded() != null) {
			return normalize(feed.getContent_encoded());
		}
		return "";
	}
}