package thirdparty.renren.renrenAPIv2;

/**
 * 基本信息
 */
public class BasicInformation {

    /**
     * 用户性别
     */
    private Sex sex;
    /**
     * 用户生日，格式为'yyyy-mm-dd'或'y0后-mm-dd'
     */
    private String birthday;
    /**
     * 家乡信息
     */
    private HomeTown homeTown;

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setHomeTown(HomeTown homeTown) {
        this.homeTown = homeTown;
    }

    public HomeTown getHomeTown() {
        return this.homeTown;
    }
}