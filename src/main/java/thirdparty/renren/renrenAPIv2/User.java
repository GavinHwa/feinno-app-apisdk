package thirdparty.renren.renrenAPIv2;

import com.feinno.app.feed.activitystreams.ActivityAuthor;
import com.feinno.app.feed.activitystreams.ActivityAuthorType;
import thirdparty.ThirdPartyUser;

import java.util.List;

/**
 * 用户
 */
public class User implements ThirdPartyUser{

    /**
     * 用户ID,eg:389414346
     */
    private long id;
    /**
     * 用户名eg:王小冋任鹏
     */
    private String name;
    /**
     * 用户头像列表
     */
    private List<Image> avatar;
    /**
     * 是否为星级用户，值“1”表示“是”；值“0”表示“不是”
     */
    private int star;
    /**
     * 用户基本信息
     */
    private BasicInformation basicInformation;
    /**
     * 用户学校信息
     */
    private List<School> education;
    /**
     * 工作信息
     */
    private List<Work> work;
    /**
     * 喜欢
     */
    private List<Like> like;
    /**
     * 感情状态
     */
    private EmotionalState emotionalState;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAvatar(List<Image> avatar) {
        this.avatar = avatar;
    }

    public List<Image> getAvatar() {
        return this.avatar;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getStar() {
        return this.star;
    }

    public void setBasicInformation(BasicInformation basicInformation) {
        this.basicInformation = basicInformation;
    }

    public BasicInformation getBasicInformation() {
        return this.basicInformation;
    }

    public void setEducation(List<School> education) {
        this.education = education;
    }

    public List<School> getEducation() {
        return this.education;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

    public List<Work> getWork() {
        return this.work;
    }

    public void setLike(List<Like> like) {
        this.like = like;
    }

    public List<Like> getLike() {
        return this.like;
    }

    public void setEmotionalState(EmotionalState emotionalState) {
        this.emotionalState = emotionalState;
    }

    public EmotionalState getEmotionalState() {
        return this.emotionalState;
    }

    @Override
    public String getThirdUserid() {
        return String.valueOf(id);
    }

    @Override
    public String getThirdAtId() {
        return getThirdName();
    }

    @Override
    public String getThirdName() {
        return name;
    }

    @Override
    public String getThirdPic() {
        if (null != avatar && avatar.size() != 0){
            for(Image image : avatar){
                if (image.getSize() == ImageSize.TINY){
                    return image.getUrl();
                }
            }
        }
        return DEFAULTFETIONHEADIMAGE;
    }

    @Override
    public String getThirdDomain() {
        return "http://www.renren.com/" + id;
    }

    @Override
    public ActivityAuthor getThirdPartyAuthor() {
        ActivityAuthor author = new ActivityAuthor();
        author.setId(getThirdUserid());
        author.setName(getThirdName());
        author.setPortrait(getThirdPic());
        author.setHomepage(getThirdDomain());
        author.setAuthorType(ActivityAuthorType.PLATFORM);
        return author;
    }
}