package thirdparty.renren.renrenAPIv2;

/**
 * 兴趣
 */
public class Like {

    /**
     * 喜欢的类型
     */
    private LikeCatagory catagory;
    /**
     * 喜欢的东西
     */
    private String name;

    public void setCatagory(LikeCatagory catagory) {
        this.catagory = catagory;
    }

    public LikeCatagory getCatagory() {
        return this.catagory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}