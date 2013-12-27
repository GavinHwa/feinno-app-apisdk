/**
 *
 */
package thirdparty.sina.oauth2.place.nearby_users;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午6:09:51
 */
@SuppressWarnings("unused")
public class ListInput extends SinaOauth2Input {
    final private static String apiURL = "https://api.weibo.com/2/place/nearby_users/list.json";
    private String access_token;// 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
    private float lat;  //纬度。有效范围：-90.0到+90.0，+表示北纬。
    private float lon;//经度。有效范围：-180.0到+180.0，+表示东经。
    private int count;   	//false	int	单页返回的记录条数，最大为50，默认为20。
    private int page	;   	//false	int	返回结果的页码，默认为1。
    private int range;      //false	 int	查询范围半径，默认为2000，最大为11132。
    private int sort;    	   //false	 int	排序方式，0：按时间、1：按距离、2：按社会化关系，默认为2。
    private int filter;		   //false	 int	（暂未启用）用户关系过滤，0：全部、1：只返回陌生人、2：只返回关注人，默认为0。
    private int gender;	   //false	 int	性别过滤，0：全部、1：男、2：女，默认为0。
    private int level;   	   //false	 int	用户级别过滤，0：全部、1：普通用户、2：VIP用户、7：达人，默认为0。
    private int startbirth;	//false	int	与参数endbirth一起定义过滤年龄段，数值为年龄大小，默认为空。
    private int endbirth;	//false	int	与参数startbirth一起定义过滤年龄段，数值为年龄大小，默认为空。
    private int offset;		//false	int	传入的经纬度是否是纠偏过，0：没纠偏、1：纠偏过，默认为0。

    public ListInput(float lat, float lon) {
        this.lon = lon;
        this.lat = lat;
        httpMethod = "GET";

        bodyArgs.add(new Arg("long", Float.toString(lon)));
        bodyArgs.add(new Arg("lat", Float.toString(lat)));
        bodyArgs.add(new Arg("source", source));

        headers.add(new Arg("Authorization", "OAuth2 " + source));
    }

    public ListInput(float lat, float lon, int count, int page) {
        this.lon = lon;
        this.lat = lat;
        this.count = count;
        this.page = page;
        httpMethod = "GET";

        bodyArgs.add(new Arg("long", Float.toString(lon)));
        bodyArgs.add(new Arg("lat", Float.toString(lat)));
        bodyArgs.add(new Arg("count", Integer.toString(count)));
        bodyArgs.add(new Arg("page", Integer.toString(page)));

        bodyArgs.add(new Arg("source", source));

        headers.add(new Arg("Authorization", "OAuth2 " + source));
    }

    public ListInput(float lat, float lon, int count, int page, int range) {
        this(lat, lon, count, page);
        this.range = range;

        bodyArgs.add(new Arg("range", Float.toString(range)));
    }

    public ListInput(float lat, float lon, int count, int page, int range, int startbirth, int endbirth) {
        this(lat, lon, count, page, range);
        this.startbirth = startbirth;
        this.endbirth = endbirth;

        bodyArgs.add(new Arg("startbirth", Integer.toString(startbirth)));
        bodyArgs.add(new Arg("endbirth", Integer.toString(endbirth)));
    }

    /* (non-Javadoc)
     * @see thirdparty.Input#getUrl()
     */
    @Override
    protected String getUrl() {
        return apiURL;
    }
}
