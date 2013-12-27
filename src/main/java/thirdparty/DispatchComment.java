package thirdparty;

import com.feinno.serialization.protobuf.ProtoEntity;
import com.feinno.serialization.protobuf.ProtoMember;

public class DispatchComment extends ProtoEntity {

	@ProtoMember(1)
	private long feedId;
	@ProtoMember(2)
	private int ownerId;
	@ProtoMember(3)
	private String comment;
	@ProtoMember(4)
	private String originalFeedId;
	@ProtoMember(5)
	private int userId;
	@ProtoMember(6)
	private String userName;
	@ProtoMember(7)
	private String userPortrait;
	@ProtoMember(8)
	private String userUrl;
	@ProtoMember(9)
	private int sourceId;
	@ProtoMember(10)
	private long created_at;

	public long getFeedId() {
		return feedId;
	}

	public DispatchComment setFeedId(long feedId) {
		this.feedId = feedId;
		return this;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public DispatchComment setOwnerId(int ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getComment() {
		return comment;
	}

	public DispatchComment setComment(String comment) {
		this.comment = comment;
		return this;
	}

	public String getOriginalFeedId() {
		return originalFeedId;
	}

	public DispatchComment setOriginalFeedId(String originalFeedId) {
		this.originalFeedId = originalFeedId;
		return this;
	}

	public int getUserId() {
		return userId;
	}

	public DispatchComment setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public DispatchComment setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public DispatchComment setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
		return this;
	}

	public String getUserUrl() {
		return userUrl;
	}

	public DispatchComment setUserUrl(String userUrl) {
		this.userUrl = userUrl;
		return this;
	}

	public DispatchComment setSourceId(int sourceId) {
		this.sourceId = sourceId;
		return this;
	}

	public int getSourceId() {
		return sourceId;
	}

	public DispatchComment setCreated_at(long created_at) {
		this.created_at = created_at;
		return this;
	}

	public long getCreated_at() {
		return created_at;
	}
}
