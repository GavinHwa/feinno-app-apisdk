package thirdparty.renren.renrenAPIv2;

/**
 * 学校
 */
public class School {

    /**
     * 学校名称
     */
    private String name;
    /**
     * 入学日期
     */
    private String year;
    /**
     * 学历
     */
    private EducationBackground educationBackground;
    /**
     * 所在专业
     */
    private String department;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }

    public void setEducationBackground(EducationBackground educationBackground) {
        this.educationBackground = educationBackground;
    }

    public EducationBackground getEducationBackground() {
        return this.educationBackground;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return this.department;
    }
}