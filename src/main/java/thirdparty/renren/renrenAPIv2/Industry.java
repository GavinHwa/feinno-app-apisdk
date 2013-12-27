package thirdparty.renren.renrenAPIv2;

/**
 * 行业
 */
public class Industry {

    /**
     * 行业类别
     */
    private String industryCategory;
    /**
     * 行业详情
     */
    private String industryDetail;

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getIndustryCategory() {
        return this.industryCategory;
    }

    public void setIndustryDetail(String industryDetail) {
        this.industryDetail = industryDetail;
    }

    public String getIndustryDetail() {
        return this.industryDetail;
    }
}