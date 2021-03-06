package thirdparty.renren.renrenAPIv2;

/**
 * 职位
 */
public class Job {

    /**
     * 职位类别
     */
    private String jobCategory;
    /**
     * 职位详情
     */
    private String jobDetail;

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobCategory() {
        return this.jobCategory;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public String getJobDetail() {
        return this.jobDetail;
    }
}