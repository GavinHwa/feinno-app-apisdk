/**
 * 
 */
package thirdparty.tencent.friends;

import com.feinno.app.feed.activitystreams.ActivityAuthor;
import com.feinno.app.feed.activitystreams.ActivityAuthorType;
import thirdparty.FollowedUsers;
import thirdparty.ThirdPartyUser;
import thirdparty.tencent.TencentOutput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.messages.thirdparty.sina.oauth2.remind.UnreadCount.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class Mutual_listOutput extends TencentOutput implements FollowedUsers{
	private String seqid;// 不明不白的东西
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}

    @Override
    public List<ThirdPartyUser> getFollowedUsers() {
        if (null != data){
            if (null != data.getInfo()){
                return new ArrayList<ThirdPartyUser>(data.getInfo());
            }
        }
        return Collections.emptyList();
    }

    public static class Data {
		private int hasnext ;// 0-表示还有数据，1-表示下页没有数据,
		private int nextstartpos;//下次请求开始位置,
		private List<Info> info;

        public int getHasnext() {
            return hasnext;
        }

        public void setHasnext(int hasnext) {
            this.hasnext = hasnext;
        }

        public int getNextstartpos() {
            return nextstartpos;
        }

        public void setNextstartpos(int nextstartpos) {
            this.nextstartpos = nextstartpos;
        }

        public List<Info> getInfo() {
            return info;
        }

        public void setInfo(List<Info> info) {
            this.info = info;
        }

        public static class Info implements ThirdPartyUser{
            private String name; // 账户名 haoduo_11798868
            private String openid;//用户唯一id 969A803C0F08F2503D7C6824A249BDEF
            private String nick;//昵称 多多
            private String headurl;//头像url "https://app.qlogo.cn/mbloghead/fc831535f9cd67956fa4
            private String fansnum;//听众数
            private String idolnum;//收听人数
            private String isvip;//是否微博认证用户 0

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOpenid() {
                return openid;
            }

            public void setOpenid(String openid) {
                this.openid = openid;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getHeadurl() {
                return headurl;
            }

            public void setHeadurl(String headurl) {
                this.headurl = headurl;
            }

            public String getFansnum() {
                return fansnum;
            }

            public void setFansnum(String fansnum) {
                this.fansnum = fansnum;
            }

            public String getIdolnum() {
                return idolnum;
            }

            public void setIdolnum(String idolnum) {
                this.idolnum = idolnum;
            }

            public String getIsvip() {
                return isvip;
            }

            public void setIsvip(String isvip) {
                this.isvip = isvip;
            }

            @Override
            public String getThirdUserid() {
                return name;
            }

            @Override
            public String getThirdAtId() {
                return name;
            }

            @Override
            public String getThirdName() {
                return nick;
            }

            @Override
            public String getThirdPic() {
                if (hasPotraite()) {
                    return headurl + "/50";
                } else {
                    return DEFAULTFETIONHEADIMAGE;
                }
            }

            @Override
            public String getThirdDomain() {
                return "http://t.qq.com/" + name;
            }

            /**
             * 判断用户是否有头像
             * @return
             */
            private boolean hasPotraite() {
                return !"".equals(headurl);
            }

            @Override
            public ActivityAuthor getThirdPartyAuthor() {
                ActivityAuthor author = new ActivityAuthor();
                author.setHomepage("http://t.qq.com/" + name);
                author.setName(nick);
                author.setAuthorType(ActivityAuthorType.OUTSITE);
                author.setPortrait(getThirdPic());
                return author;
            }
        }
    }
}
