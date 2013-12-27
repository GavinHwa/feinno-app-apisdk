package thirdparty;


import com.feinno.app.feed.activitystreams.ActivityAuthor;

/**
 * Created with IntelliJ IDEA.
 *
 * User: srp
 * Date: 13-9-6
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
public interface UserTransformer {
    public ActivityAuthor toActivityAuthor(ThirdPartyUser thirdPartyUser);
}
