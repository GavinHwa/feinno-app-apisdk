package thirdparty.rss;

import java.util.Comparator;

public class RssFeed {

	private String title;
	private String content_encoded;
	private String pubDate;
	private String pic_src;
	private String link;
	private String fetionLink;
	private long realPubDate;
	private Object page;//这是为了避免在这里引用更高级的对象
	private Object context;//这是为了避免在这里引用更高级的对象
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent_encoded() {
		return content_encoded;
	}
	public void setContent_encoded(String content_encode) {
		this.content_encoded = content_encode;
	}
	public void setPic_src(String pic_src) {
		this.pic_src = pic_src;
	}
	public String getPic_src() {
		return pic_src;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getPubDate() {
		return pubDate;
	}
	public long getRealPubDate() {
		return realPubDate;
	}
	public void setRealPubDate(long realPubDate) {
		this.realPubDate = realPubDate;
	}
	public Object getPage() {
		return page;
	}
	public void setPage(Object page) {
		this.page = page;
	}
	public Object getContext() {
		return context;
	}
	public void setContext(Object context) {
		this.context = context;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getFetionLink() {
		return fetionLink;
	}
	public void setFetionLink(String fetionLink) {
		this.fetionLink = fetionLink;
	}
}

class RssFeedComparor  implements Comparator<RssFeed>{
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(RssFeed o1, RssFeed o2) {
		long differ= o1.getRealPubDate() - o2.getRealPubDate();
		if (differ > 0){
			return 1;
		} else if (differ < 0){
			return -1;
		} else {
			return 0;
		}
	}
}
