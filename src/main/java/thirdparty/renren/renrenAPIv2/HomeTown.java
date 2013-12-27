package thirdparty.renren.renrenAPIv2;

/**
 * 家乡
 */
public class HomeTown {

    /**
     * 所在省份
     */
    private String province;
    /**
     * 所在城市
     */
    private String city;

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return this.province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }
}