package thirdparty.sina;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpengsq
 * Date: 13-9-27
 * Time: 下午2:45
 * To change this template use File | Settings | File Templates.
 */
public class UserTest {

    private User user = new User();

    @Test
    public void testGetThirdUserid() throws Exception {
        assertEquals("1171176422",user.getThirdUserid());
    }

    @Test
    public void testGetThirdName() throws Exception {
        assertEquals("AppleNate",user.getThirdName());
    }

    @Test
    public void testGetThirdPic() throws Exception {
        assertEquals("http://tp3.sinaimg.cn/1171176422/50/5630951670/1",user.getThirdPic());
    }

    @Test
    public void testGetThirdDomain() throws Exception {
        assertEquals("http://weibo.com/applenate",user.getThirdDomain());
    }

    @Before
    public void setUp(){
        user.fromJson("{\"id\":1171176422,\"idstr\":\"1171176422\"," +
                "\"class1\":1,\"screen_name\":\"AppleNate\",\"name\":\"AppleNate\",\"province\":\"11\",\"city\":\"5\",\"location\":\"北京 朝阳区\",\"description\":\"爱美剧，爱折腾互联网 http://www.AppleNate.com\",\"url\":\"http://www.AppleNate.com/\",\"profile_image_url\":\"http://tp3.sinaimg.cn/1171176422/50/5630951670/1\",\"cover_image\":\"http://ww1.sinaimg.cn/crop.0.0.980.245/45cebbe6jw1dwkydjmkdvj.jpg\",\"profile_url\":\"applenate\",\"domain\":\"applenate\",\"weihao\":\"\",\"gender\":\"m\",\"followers_count\":7120,\"friends_count\":1001,\"statuses_count\":7188,\"favourites_count\":223,\"created_at\":\"Wed Sep 02 11:04:04 +0800 2009\",\"following\":true,\"allow_all_act_msg\":false,\"geo_enabled\":true,\"verified\":true,\"verified_type\":0,\"remark\":\"孙卯辰\",\"ptype\":0,\"allow_all_comment\":true,\"avatar_large\":\"http://tp3.sinaimg.cn/1171176422/180/5630951670/1\",\"avatar_hd\":\"http://tp3.sinaimg.cn/1171176422/180/5630951670/1\",\"verified_reason\":\"迷尚网产品总监；科技娲母TechWom合伙创始人孙卯辰\",\"follow_me\":true,\"online_status\":1,\"bi_followers_count\":725,\"lang\":\"zh-cn\",\"star\":0,\"mbtype\":0,\"mbrank\":0,\"block_word\":0}");
    }
}
