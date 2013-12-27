/**
 * 
 */
package thirdparty.sina;

import com.feinno.StringUtils;
import com.feinno.app.feed.activitystreams.ActivityAuthor;
import com.feinno.app.feed.activitystreams.ActivityAuthorType;
import thirdparty.JsonSerializableClass;
import thirdparty.ThirdPartyUser;


/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.thirdparty.sina.oauth2.User.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午7:23:52
 *
 */
public class User extends JsonSerializableClass implements ThirdPartyUser{
	private String id;//用户微博id
	private String idstr;//用户微博id的文字版
	private String screen_name;//用户屏显名称,
	private String name;//用户名称,
	private String province;// 省市的id号,
	private String city;// 城市代号,
	private String location;// 所在地的区,
	private String description;// 个人简介,
	private String url;// 个人网址,
	private String profile_image_url;//个人头像地址,
	private String cover_image;// 个人主页的抬头图片,
	private String profile_url;//个人资料地址,
	private String domain;//个人主页的地址,
	private String weihao;// 微号,
	private String gender;// 性别，m表示男性，f表示女性,
	private String followers_count;// 听众数量,
	private String friends_count;// 关注数量,
	private String statuses_count;// 发布微博数量,
	private String favourites_count;// 收藏数量,
	private String created_at;// 发布时间"Mon Mar 14 11:45:12 +0800 2011",
	private String following;// 当前用户是否收听该用户,
	private String allow_all_act_msg;// 允许所有人评论,
	private String geo_enabled;// 允许地理信息,
	private String verified;// 实名验证,
	private String verified_type;// -1表示没有验证,
	private String allow_all_comment;// 允许所有人评论,
	private String avatar_large;// 高清大头像,
	private String verified_reason;// 验证的理由,
	private String follow_me;// 收听我,
	private String online_status;// 0应该是不在线。具体未知
	private String bi_followers_count;// 互粉的数量
	private String lang;// 语言"zh-cn"
    private float lat;    //纬度
    private float lon;   //经度
    private String last_at; //上次登录时间
    private String distance;//距离

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getLast_at() {
        return last_at;
    }

    public void setLast_at(String last_at) {
        this.last_at = last_at;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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
	 * @return the idstr
	 */
	public String getIdstr() {
		return idstr;
	}
	/**
	 * @param idstr the idstr to set
	 */
	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}
	/**
	 * @return the screen_name
	 */
	public String getScreen_name() {
		return screen_name;
	}
	/**
	 * @param screen_name the screen_name to set
	 */
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
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
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the profile_image_url
	 */
	public String getProfile_image_url() {
		return profile_image_url;
	}
	/**
	 * @param profile_image_url the profile_image_url to set
	 */
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	/**
	 * @return the cover_image
	 */
	public String getCover_image() {
		return cover_image;
	}
	/**
	 * @param cover_image the cover_image to set
	 */
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	/**
	 * @return the profile_url
	 */
	public String getProfile_url() {
		return profile_url;
	}
	/**
	 * @param profile_url the profile_url to set
	 */
	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}
	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the weihao
	 */
	public String getWeihao() {
		return weihao;
	}
	/**
	 * @param weihao the weihao to set
	 */
	public void setWeihao(String weihao) {
		this.weihao = weihao;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the followers_count
	 */
	public String getFollowers_count() {
		return followers_count;
	}
	/**
	 * @param followers_count the followers_count to set
	 */
	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}
	/**
	 * @return the friends_count
	 */
	public String getFriends_count() {
		return friends_count;
	}
	/**
	 * @param friends_count the friends_count to set
	 */
	public void setFriends_count(String friends_count) {
		this.friends_count = friends_count;
	}
	/**
	 * @return the statuses_count
	 */
	public String getStatuses_count() {
		return statuses_count;
	}
	/**
	 * @param statuses_count the statuses_count to set
	 */
	public void setStatuses_count(String statuses_count) {
		this.statuses_count = statuses_count;
	}
	/**
	 * @return the favourites_count
	 */
	public String getFavourites_count() {
		return favourites_count;
	}
	/**
	 * @param favourites_count the favourites_count to set
	 */
	public void setFavourites_count(String favourites_count) {
		this.favourites_count = favourites_count;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the following
	 */
	public String getFollowing() {
		return following;
	}
	/**
	 * @param following the following to set
	 */
	public void setFollowing(String following) {
		this.following = following;
	}
	/**
	 * @return the allow_all_act_msg
	 */
	public String getAllow_all_act_msg() {
		return allow_all_act_msg;
	}
	/**
	 * @param allow_all_act_msg the allow_all_act_msg to set
	 */
	public void setAllow_all_act_msg(String allow_all_act_msg) {
		this.allow_all_act_msg = allow_all_act_msg;
	}
	/**
	 * @return the geo_enabled
	 */
	public String getGeo_enabled() {
		return geo_enabled;
	}
	/**
	 * @param geo_enabled the geo_enabled to set
	 */
	public void setGeo_enabled(String geo_enabled) {
		this.geo_enabled = geo_enabled;
	}
	/**
	 * @return the verified
	 */
	public String getVerified() {
		return verified;
	}
	/**
	 * @param verified the verified to set
	 */
	public void setVerified(String verified) {
		this.verified = verified;
	}
	/**
	 * @return the verified_type
	 */
	public String getVerified_type() {
		return verified_type;
	}
	/**
	 * @param verified_type the verified_type to set
	 */
	public void setVerified_type(String verified_type) {
		this.verified_type = verified_type;
	}
	/**
	 * @return the allow_all_comment
	 */
	public String getAllow_all_comment() {
		return allow_all_comment;
	}
	/**
	 * @param allow_all_comment the allow_all_comment to set
	 */
	public void setAllow_all_comment(String allow_all_comment) {
		this.allow_all_comment = allow_all_comment;
	}
	/**
	 * @return the avatar_large
	 */
	public String getAvatar_large() {
		return avatar_large;
	}
	/**
	 * @param avatar_large the avatar_large to set
	 */
	public void setAvatar_large(String avatar_large) {
		this.avatar_large = avatar_large;
	}
	/**
	 * @return the verified_reason
	 */
	public String getVerified_reason() {
		return verified_reason;
	}
	/**
	 * @param verified_reason the verified_reason to set
	 */
	public void setVerified_reason(String verified_reason) {
		this.verified_reason = verified_reason;
	}
	/**
	 * @return the follow_me
	 */
	public String getFollow_me() {
		return follow_me;
	}
	/**
	 * @param follow_me the follow_me to set
	 */
	public void setFollow_me(String follow_me) {
		this.follow_me = follow_me;
	}
	/**
	 * @return the online_status
	 */
	public String getOnline_status() {
		return online_status;
	}
	/**
	 * @param online_status the online_status to set
	 */
	public void setOnline_status(String online_status) {
		this.online_status = online_status;
	}
	/**
	 * @return the bi_followers_count
	 */
	public String getBi_followers_count() {
		return bi_followers_count;
	}
	/**
	 * @param bi_followers_count the bi_followers_count to set
	 */
	public void setBi_followers_count(String bi_followers_count) {
		this.bi_followers_count = bi_followers_count;
	}
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}
	/* (non-Javadoc)
	 * @see thirdparty.ThirdPartyUser#getThirdUserid()
	 */
	@Override
	public String getThirdUserid() {
		return idstr;
	}

    @Override
    public String getThirdAtId() {
        return getThirdName();
    }

    /* (non-Javadoc)
     * @see thirdparty.ThirdPartyUser#getThirdName()
     */
	@Override
	public String getThirdName() {
		return screen_name;
	}
	/* (non-Javadoc)
	 * @see thirdparty.ThirdPartyUser#getThirdPic()
	 */
	@Override
	public String getThirdPic() {
        if (notSinaDefaultImage()){
            return profile_image_url;
        } else {
            return DEFAULTFETIONHEADIMAGE;
        }
	}

    /**
     * 能够判断是否
     * @return
     */
    private boolean notSinaDefaultImage() {
        return profile_image_url != null && !profile_image_url.contains("/style/images/face/");
    }

    /* (non-Javadoc)
     * @see thirdparty.ThirdPartyUser#getThirdDomain()
     */
	@Override
	public String getThirdDomain() {
        if(!StringUtils.isEmpty(domain)){
		    return "http://weibo.com/" + domain;
        } else if (!StringUtils.isEmpty(profile_url)){
            return "http://weibo.com/" + profile_url;
        } else {
            return "http://weibo.com/";
        }
	}
	/* (non-Javadoc)
	 * @see thirdparty.ThirdPartyUser#getThirdPartyAuthor()
	 */
	@Override
	public ActivityAuthor getThirdPartyAuthor() {
		ActivityAuthor author = new ActivityAuthor();
		author.setHomepage(getThirdDomain());
		author.setName(getThirdName());
		author.setAuthorType(ActivityAuthorType.OUTSITE);
        author.setPortrait(getThirdPic());

		return author;
	}
}
