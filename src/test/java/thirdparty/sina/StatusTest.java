package thirdparty.sina;

import com.feinno.app.feed.activitystreams.Activity;
import org.junit.Before;
import org.junit.Test;
import thirdparty.sina.Status;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-24
 * Time: 下午7:46
 * To change this template use File | Settings | File Templates.
 */
public class StatusTest {
    private Status status = new Status();;
    @Before
    public void setUp(){
        String json = "{\"created_at\":\"Fri Sep 27 14:20:16 +0800 2013\"," +
                "\"id\":3627147501335366,\"mid\":\"3627147501335366\"," +
                "\"idstr\":\"3627147501335366\"," +
                "\"text\":\"收到了@来往 送的16注彩票。不知道能不能领取盒子\"," +
                "\"source\":\"<a href=\\\"http://app.weibo" +
                ".com/t/feed/9ksdit\\\" rel=\\\"nofollow\\\">iPhone客户端</a>\"," +
                "\"favorited\":false,\"truncated\":false," +
                "\"in_reply_to_status_id\":\"\",\"in_reply_to_user_id\":\"\"," +
                "\"in_reply_to_screen_name\":\"\",\"pic_urls\":[]," +
                "\"geo\":null,\"user\":{\"id\":1171176422," +
                "\"idstr\":\"1171176422\",\"class\":1," +
                "\"screen_name\":\"AppleNate\",\"name\":\"AppleNate\"," +
                "\"province\":\"11\",\"city\":\"5\",\"location\":\"北京 朝阳区\"," +
                "\"description\":\"爱美剧，爱折腾互联网 http://www.AppleNate.com\"," +
                "\"url\":\"http://www.AppleNate.com/\"," +
                "\"profile_image_url\":\"http://tp3.sinaimg" +
                ".cn/1171176422/50/5630951670/1\"," +
                "\"cover_image\":\"http://ww1.sinaimg.cn/crop.0.0.980" +
                ".245/45cebbe6jw1dwkydjmkdvj.jpg\"," +
                "\"profile_url\":\"applenate\",\"domain\":\"applenate\"," +
                "\"weihao\":\"\",\"gender\":\"m\",\"followers_count\":7120," +
                "\"friends_count\":1001,\"statuses_count\":7188," +
                "\"favourites_count\":223,\"created_at\":\"Wed Sep 02 " +
                "11:04:04 +0800 2009\",\"following\":true," +
                "\"allow_all_act_msg\":false,\"geo_enabled\":true," +
                "\"verified\":true,\"verified_type\":0,\"remark\":\"孙卯辰\"," +
                "\"ptype\":0,\"allow_all_comment\":true," +
                "\"avatar_large\":\"http://tp3.sinaimg" +
                ".cn/1171176422/180/5630951670/1\",\"avatar_hd\":\"http://tp3" +
                ".sinaimg.cn/1171176422/180/5630951670/1\"," +
                "\"verified_reason\":\"迷尚网产品总监；科技娲母TechWom合伙创始人孙卯辰\"," +
                "\"follow_me\":true,\"online_status\":1," +
                "\"bi_followers_count\":725,\"lang\":\"zh-cn\",\"star\":0," +
                "\"mbtype\":0,\"mbrank\":0,\"block_word\":0}," +
                "\"annotations\":[{\"client_mblogid\":\"iPhone-81580E61-D746" +
                "-4D5B-9672-66CE81BA77BE\"}],\"reposts_count\":0," +
                "\"comments_count\":0,\"attitudes_count\":0,\"mlevel\":0," +
                "\"visible\":{\"type\":0,\"list_id\":0}}";

        status.fromJson(json);
    }

    @Test
    public void testToActiviy() throws Exception {
        Activity activity = status.toActivity();
        assertEquals("2013-09-27 14:20:16", activity.getPublished());
    }

    @Test
    public void testIsAvailable() throws Exception {

    }

    @Test
    public void testToJson() throws Exception {
        Status status = new Status();
        status.setCreated_at("Fri Sep 27 14:20:16 +0800 2013");
        status.setId("3627147501335366");
        status.setMid("3627147501335366");
        status.setIdstr("3627147501335366");
        status.setText("收到了@来往 送的16注彩票。不知道能不能领取盒子");
        status.setSource("<a href=\"http://app.weibo.com/t/feed/9ksdit\" " +
                "rel=\"nofollow\">iPhone客户端</a>");
        status.setFavorited(false);
        status.setTruncated(false);
        status.setIn_reply_to_status_id("");
        status.setIn_reply_to_user_id("");
        status.setIn_reply_to_screen_name("");
        assertEquals("{\"created_at\":\"Fri Sep 27 14:20:16 +0800 2013\"," +
                "\"id\":\"3627147501335366\",\"mid\":\"3627147501335366\"," +
                "\"idstr\":\"3627147501335366\"," +
                "\"text\":\"收到了@来往 送的16注彩票。不知道能不能领取盒子\"," +
                "\"source\":\"<a href=\\\"http://app.weibo" +
                ".com/t/feed/9ksdit\\\" rel=\\\"nofollow\\\">iPhone客户端</a>\"," +
                "\"favorited\":false,\"truncated\":false," +
                "\"in_reply_to_status_id\":\"\",\"in_reply_to_user_id\":\"\"," +
                "\"in_reply_to_screen_name\":\"\",\"thumbnail_pic\":null," +
                "\"bmiddle_pic\":null,\"original_pic\":null,\"geo\":null," +
                "\"uid\":null,\"user\":null,\"retweeted_status\":null," +
                "\"reposts_count\":null,\"comments_count\":null," +
                "\"attitudes_count\":null,\"mlevel\":null,\"visible\":null," +
                "\"available\":false}", status.toJson());
    }


    @Test
    public void testFromJson() throws Exception {
        String json = "{\"created_at\":\"Fri Sep 27 14:20:16 +0800 2013\"," +
                "\"id\":3627147501335366,\"mid\":\"3627147501335366\",\"idstr\":\"3627147501335366\",\"text\":\"收到了@来往 送的16注彩票。不知道能不能领取盒子\",\"source\":\"<a href=\\\"http://app.weibo.com/t/feed/9ksdit\\\" rel=\\\"nofollow\\\">iPhone客户端</a>\",\"favorited\":false,\"truncated\":false,\"in_reply_to_status_id\":\"\",\"in_reply_to_user_id\":\"\",\"in_reply_to_screen_name\":\"\",\"pic_urls\":[],\"geo\":null,\"user\":{\"id\":1171176422,\"idstr\":\"1171176422\",\"class\":1,\"screen_name\":\"AppleNate\",\"name\":\"AppleNate\",\"province\":\"11\",\"city\":\"5\",\"location\":\"北京 朝阳区\",\"description\":\"爱美剧，爱折腾互联网 http://www.AppleNate.com\",\"url\":\"http://www.AppleNate.com/\",\"profile_image_url\":\"http://tp3.sinaimg.cn/1171176422/50/5630951670/1\",\"cover_image\":\"http://ww1.sinaimg.cn/crop.0.0.980.245/45cebbe6jw1dwkydjmkdvj.jpg\",\"profile_url\":\"applenate\",\"domain\":\"applenate\",\"weihao\":\"\",\"gender\":\"m\",\"followers_count\":7120,\"friends_count\":1001,\"statuses_count\":7188,\"favourites_count\":223,\"created_at\":\"Wed Sep 02 11:04:04 +0800 2009\",\"following\":true,\"allow_all_act_msg\":false,\"geo_enabled\":true,\"verified\":true,\"verified_type\":0,\"remark\":\"孙卯辰\",\"ptype\":0,\"allow_all_comment\":true,\"avatar_large\":\"http://tp3.sinaimg.cn/1171176422/180/5630951670/1\",\"avatar_hd\":\"http://tp3.sinaimg.cn/1171176422/180/5630951670/1\",\"verified_reason\":\"迷尚网产品总监；科技娲母TechWom合伙创始人孙卯辰\",\"follow_me\":true,\"online_status\":1,\"bi_followers_count\":725,\"lang\":\"zh-cn\",\"star\":0,\"mbtype\":0,\"mbrank\":0,\"block_word\":0},\"annotations\":[{\"client_mblogid\":\"iPhone-81580E61-D746-4D5B-9672-66CE81BA77BE\"}],\"reposts_count\":0,\"comments_count\":0,\"attitudes_count\":0,\"mlevel\":0,\"visible\":{\"type\":0,\"list_id\":0}}";

        Status status = new Status();
        status.fromJson(json);
        assertEquals("Fri Sep 27 14:20:16 +0800 2013", status.getCreated_at());
        assertEquals("3627147501335366", status.getId());
        assertEquals("3627147501335366", status.getMid());
        assertEquals("3627147501335366", status.getIdstr());
        assertEquals("收到了@来往 送的16注彩票。不知道能不能领取盒子", status.getText());
        assertEquals("<a href=\"http://app.weibo.com/t/feed/9ksdit\" " +
                "rel=\"nofollow\">iPhone客户端</a>", status.getSource());
        assertEquals(false, status.isFavorited());
        assertEquals(false, status.isTruncated());
        assertEquals("", status.getIn_reply_to_status_id());
        assertEquals("", status.getIn_reply_to_user_id());
        assertEquals("", status.getIn_reply_to_screen_name());
        assertNotNull(status.getUser());
    }
}
