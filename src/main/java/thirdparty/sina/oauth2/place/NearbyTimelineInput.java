/**
 *
 */
package thirdparty.sina.oauth2.place;


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
public class NearbyTimelineInput extends SinaOauth2Input {
    final private static String apiURL = "https://api.weibo.com/2/place/nearby_timeline.json";
    private String access_token;// 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
    private float lat;  //纬度。有效范围：-90.0到+90.0，+表示北纬。
    private float longs;//经度。有效范围：-180.0到+180.0，+表示东经。
    private int range;//搜索范围，单位米，默认2000米，最大11132米。
    private long starttime;            //开始时间，Unix时间戳。
    private long endtime;            //结束时间，Unix时间戳。
    private int sort; //排序方式。默认为0，按时间排序；为1时按与中心点距离进行排序。
    private int count;// 单页返回的记录条数，最大不超过100，默认为20。
    private int page;// 返回结果的页码，默认为1。
    private int base_app;// 是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
    private int offset;//

    public NearbyTimelineInput(float lat, float longs) {
        this.longs = longs;
        this.lat = lat;
        httpMethod = "GET";

        bodyArgs.add(new Arg("long", Float.toString(longs)));
        bodyArgs.add(new Arg("lat", Float.toString(lat)));
        bodyArgs.add(new Arg("source", source));

        headers.add(new Arg("Authorization", "OAuth2 " + source));
    }

    public NearbyTimelineInput(float lat, float longs, long starttime, int count, int page, int range) {
        this(lat, longs, starttime, count, page);
        this.range = range;

        bodyArgs.add(new Arg("range", Integer.toString(range)));
    }

    public NearbyTimelineInput(float lat, float longs, long starttime, int count, int page) {
        this(lat, longs, count, page);
        this.starttime = starttime;

        bodyArgs.add(new Arg("starttime", Long.toString(starttime)));
    }

    public NearbyTimelineInput(float lat, float longs, int count, int page) {
        this.longs = longs;
        this.lat = lat;
        this.count = count;
        this.page = page;
        httpMethod = "GET";

        bodyArgs.add(new Arg("long", Float.toString(longs)));
        bodyArgs.add(new Arg("lat", Float.toString(lat)));
        bodyArgs.add(new Arg("count", Integer.toString(count)));
        bodyArgs.add(new Arg("page", Integer.toString(page)));

        bodyArgs.add(new Arg("source", source));

        headers.add(new Arg("Authorization", "OAuth2 " + source));
    }

    public NearbyTimelineInput(float lat, float longs, int count, int page, int range) {
        this(lat, longs, count, page);
        this.range = range;

        bodyArgs.add(new Arg("range", Float.toString(range)));
    }

    /* (non-Javadoc)
     * @see thirdparty.Input#getUrl()
     */
    @Override
    protected String getUrl() {
        return apiURL;
    }
}
