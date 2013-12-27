package thirdparty;


import com.feinno.app.feed.activitystreams.Activity;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-4                               '
 * Time: 下午2:32
 */
public interface ThirdPartyFeed {
    /**
     * 将第三方站点转换为标准的同窗动态。
     *
     *  ※转换后需要处理一次短链、视频，以及由短链指向的图片（网易方式）。
     * @return 返回标准的acticvity结构
     */
    public Activity toActivity() throws SnsException;

    /**
     * 看看该条feed是否可用，如果缺乏必要信息就不要了。比如新浪被删除的动态
     * 但是如果是飞信发布的动态还需要在调用者再次判断，因为里面无法排除转发者是新浪但是原创是飞信发布的情况
     * @return 返回真表示该第三方动态结构符合标准，可以转换
     */
    public boolean isAvailable();
}
