/**
 * 
 */
package thirdparty.renren.oauth1;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.FeedMedia.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-4 下午5:50:38
 *
 */
public class FeedMedia {
	private String href;//表示媒体内容的链接地址feed_media子节点
	private String media_type;//表示媒体内容的类型，目前有“photo”, “album”, “link”, “video”, “audio”, “status” feed_media子节点
	private String src;//表示媒体内容的原地址 feed_media子节点
	private String raw_src;//media_type为“photo”时特有，代表未加工过的原图URL。
	private String content;//表示媒体文本相关内容，例如：media_type为“status”代表状态的内容；media_type为“photo”代表照片的描述信息。
	private String media_id;//表示媒体内容的id，例如相片的id feed_media子节点
	private String owner_id;//表示媒体内容的所有者idfeed_media子节点
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * @return the media_type
	 */
	public String getMedia_type() {
		return media_type;
	}
	/**
	 * @param media_type the media_type to set
	 */
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}
	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	/**
	 * @return the raw_src
	 */
	public String getRaw_src() {
		return raw_src;
	}
	/**
	 * @param raw_src the raw_src to set
	 */
	public void setRaw_src(String raw_src) {
		this.raw_src = raw_src;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}
	/**
	 * @param media_id the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	/**
	 * @return the owner_id
	 */
	public String getOwner_id() {
		return owner_id;
	}
	/**
	 * @param owner_id the owner_id to set
	 */
	public void setOwner_id(String owner_id) {
		this.owner_id = owner_id;
	}
}
