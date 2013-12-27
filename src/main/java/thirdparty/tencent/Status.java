/**
 * 
 */
package thirdparty.tencent;

import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.Info.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-11 上午11:38:15
 *
 */
public class Status {
	private String	text;//微博内容
	private String	origtext;//原始内容
	private long	count;//微博被转次数
	private long	mcount;//点评次数
	private String	from;//来源
	private String	fromurl;//来源url
	private String	id;//微博唯一id
	private List<String> image;//图片url列表
	private Video	video;//
	private Music	music;//
	private String	name;//发表人帐户名
	private String	openid;//用户唯一id，与name相对应
	private String	nick;//发表人昵称
	private int	self;//是否自已发的的微博，0-不是，1-是
	private long	timestamp;//发表时间
	private int	type;//微博类型，1-原创发表，2-转载，3-私信，4-回复，5-空回，6-提及，7-评论
	private String	head;//发表者头像url
	private String	location;//发表者所在地
	private String	country_code;//国家码（其他时间线一样）
	private String	province_code;//省份码（其他时间线一样）
	private String	city_code;//城市码（其他时间线一样）
	private int	isvip;//是否微博认证用户，0-不是，1-是
	private String	geo;//发表者地理信息
	private int	status;//微博状态，0-正常，1-系统删除，2-审核中，3-用户删除，4-根删除
	private String	emotionurl;//心情图片url
	private int	emotiontype;//心情类型
	private Status	source;//当type=2时，source即为源tweet
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the origtext
	 */
	public String getOrigtext() {
		return origtext;
	}
	/**
	 * @param origtext the origtext to set
	 */
	public void setOrigtext(String origtext) {
		this.origtext = TencentEmotionTransformer.transform2Our(origtext);
	}
	/**
	 * @return the count
	 */
	public long getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(long count) {
		this.count = count;
	}
	/**
	 * @return the mcount
	 */
	public long getMcount() {
		return mcount;
	}
	/**
	 * @param mcount the mcount to set
	 */
	public void setMcount(long mcount) {
		this.mcount = mcount;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the fromurl
	 */
	public String getFromurl() {
		return fromurl;
	}
	/**
	 * @param fromurl the fromurl to set
	 */
	public void setFromurl(String fromurl) {
		this.fromurl = fromurl;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the image
	 */
	public List<String> getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(List<String> image) {
		this.image = image;
	}
	/**
	 * @return the video
	 */
	public Video getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(Video video) {
		this.video = video;
	}
	/**
	 * @return the music
	 */
	public Music getMusic() {
		return music;
	}
	/**
	 * @param music the music to set
	 */
	public void setMusic(Music music) {
		this.music = music;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}
	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}
	/**
	 * @return the self
	 */
	public int getSelf() {
		return self;
	}
	/**
	 * @param self the self to set
	 */
	public void setSelf(int self) {
		this.self = self;
	}
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the head
	 */
	public String getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(String head) {
		this.head = head;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the country_code
	 */
	public String getCountry_code() {
		return country_code;
	}
	/**
	 * @param country_code the country_code to set
	 */
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	/**
	 * @return the province_code
	 */
	public String getProvince_code() {
		return province_code;
	}
	/**
	 * @param province_code the province_code to set
	 */
	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}
	/**
	 * @return the city_code
	 */
	public String getCity_code() {
		return city_code;
	}
	/**
	 * @param city_code the city_code to set
	 */
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	/**
	 * @return the isvip
	 */
	public int getIsvip() {
		return isvip;
	}
	/**
	 * @param isvip the isvip to set
	 */
	public void setIsvip(int isvip) {
		this.isvip = isvip;
	}
	/**
	 * @return the geo
	 */
	public String getGeo() {
		return geo;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the emotionurl
	 */
	public String getEmotionurl() {
		return emotionurl;
	}
	/**
	 * @param emotionurl the emotionurl to set
	 */
	public void setEmotionurl(String emotionurl) {
		this.emotionurl = emotionurl;
	}
	/**
	 * @return the emotiontype
	 */
	public int getEmotiontype() {
		return emotiontype;
	}
	/**
	 * @param emotiontype the emotiontype to set
	 */
	public void setEmotiontype(int emotiontype) {
		this.emotiontype = emotiontype;
	}
	/**
	 * @return the source
	 */
	public Status getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Status source) {
		this.source = source;
	}
}
