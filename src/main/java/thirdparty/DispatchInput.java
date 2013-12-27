package thirdparty;

import com.feinno.serialization.protobuf.ProtoEntity;
import com.feinno.serialization.protobuf.ProtoMember;
import com.feinno.app.feed.activitystreams.Activity;
import com.feinno.app.feed.activitystreams.ActivityCodec;

import java.io.IOException;
import java.util.List;

/**
 * 这个类是用来把外站feed转换为站内feed结构用的
 * @author	shangrenpeng
 * @date	2012-10-24 下午5:25:55
 *
 */
public class DispatchInput extends ProtoEntity implements Cloneable {

	@ProtoMember(1)
	private int userId;
	@ProtoMember(2)
	private List<Integer> atUserIds;
	@ProtoMember(3)
	private String feed;
	@ProtoMember(4)
	private int classify;
	@ProtoMember(5)
	private int dispatchFlag;
	@ProtoMember(6)
	private long feedId;
	@ProtoMember(7)
	private long sourceFeedId;
	@ProtoMember(8)
	private int sourceId;
	@ProtoMember(9)
	private String thirdPartFeedId;
	@ProtoMember(10)
	private boolean hasDangerousWord;
	@ProtoMember(11)
	private List<String> topicTitles;
	@ProtoMember(12)
	private String clientIp;
	@ProtoMember(13)
	private int categorytype;
	@ProtoMember(14)
	private long syncTime;
	@ProtoMember(15)
	private String blogId;
	@ProtoMember(16)
	private int signInFlag;
	@ProtoMember(17)
	private List<Integer> schoolUserIds;
	@ProtoMember(18)
	private int merger;
	@ProtoMember(19)
	private String schoolcode;
	@ProtoMember(20)
	private int oriUserId;

	public DispatchInput(Activity activity, int classify, int serviceId, int userid, String thirdPartfeedId,
			List<Integer> atUserids, long syncTime, int oriUserId, int sourceFeedId) throws IOException {
		setClassify(classify);
		setFeed(ActivityCodec.toJson(activity));
		setSourceId(serviceId);
		setUserId(userid);
		setThirdPartFeedId(thirdPartfeedId);
		setAtUserIds(atUserids);
		setSyncTime(syncTime);
		setOriUserId(oriUserId);
		setSourceFeedId(sourceFeedId);
	}
	
	public DispatchInput(){
		
	}

	public int getUserId() {
		return userId;
	}

	public DispatchInput setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public List<Integer> getAtUserIds() {
		return atUserIds;
	}

	public DispatchInput setAtUserIds(List<Integer> atUserIds) {
		this.atUserIds = atUserIds;
		return this;
	}

	public String getFeed() {
		return feed;
	}

	public DispatchInput setFeed(String feed) {
		this.feed = feed;
		return this;
	}

	public int getDispatchFlag() {
		return dispatchFlag;
	}

	public DispatchInput setDispatchFlag(int dispatchFlag) {
		this.dispatchFlag = dispatchFlag;
		return this;
	}

	public int getClassify() {
		return classify;
	}

	public DispatchInput setClassify(int classify) {
		this.classify = classify;
		return this;
	}

	public long getFeedId() {
		return feedId;
	}

	public DispatchInput setFeedId(long feedId) {
		this.feedId = feedId;
		return this;
	}

	public long getSourceFeedId() {
		return sourceFeedId;
	}

	public DispatchInput setSourceFeedId(long sourceFeedId) {
		this.sourceFeedId = sourceFeedId;
		return this;
	}

	public DispatchInput setSourceId(int sourceId) {
		this.sourceId = sourceId;
		return this;
	}

	public int getSourceId() {
		return sourceId;
	}

	public DispatchInput setThirdPartFeedId(String thirdPartFeedId) {
		this.thirdPartFeedId = thirdPartFeedId;
		return this;
	}

	public String getThirdPartFeedId() {
		return thirdPartFeedId;
	}

	public DispatchInput setHasDangerousWord(boolean hasDangerousWord) {
		this.hasDangerousWord = hasDangerousWord;
		return this;
	}

	public boolean getHasDangerousWord() {
		return hasDangerousWord;
	}

	public DispatchInput setTopicTitles(List<String> topicTitles) {
		this.topicTitles = topicTitles;
		return this;
	}

	public List<String> getTopicTitles() {
		return topicTitles;
	}

	public String getClientIp() {
		return clientIp;
	}

	public DispatchInput setClientIp(String clientIp) {
		this.clientIp = clientIp;
		return this;
	}

	public DispatchInput setCategorytype(int categorytype) {
		this.categorytype = categorytype;
		return this;
	}

	public int getCategorytype() {
		return categorytype;
	}

	public DispatchInput setSyncTime(long syncTime) {
		this.syncTime = syncTime;
		return this;
	}

	public long getSyncTime() {
		return syncTime;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public int getSignInFlag() {
		return signInFlag;
	}

	public void setSignInFlag(int signInFlag) {
		this.signInFlag = signInFlag;
	}

	public List<Integer> getSchoolUserIds() {
		return schoolUserIds;
	}

	public void setSchoolUserIds(List<Integer> schoolUserIds) {
		this.schoolUserIds = schoolUserIds;
	}

	public int getMerger() {
		return merger;
	}

	public void setMerger(int merger) {
		this.merger = merger;
	}

	public String getSchoolcode() {
		return schoolcode;
	}

	public void setSchoolcode(String schoolcode) {
		this.schoolcode = schoolcode;
	}

	public int getOriUserId() {
		return oriUserId;
	}

	public DispatchInput setOriUserId(int oriUserId) {
		this.oriUserId = oriUserId;
		return this;
	}
	
	public boolean isFromCache() {
		return fromCache;
	}

	public void setFromCache(boolean fromCache) {
		this.fromCache = fromCache;
	}

	private boolean fromCache = false;
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		DispatchInput input = null;
		try {
			input = (DispatchInput) super.clone();
		} catch (Exception e) {
			throw new CloneNotSupportedException("OMG");
		}
		return input;
	}
}
