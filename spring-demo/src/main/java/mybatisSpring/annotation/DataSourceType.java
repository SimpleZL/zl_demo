package mybatisSpring.annotation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-01-02
 */
public enum DataSourceType {
    CMS_RW("cmsRw"),
    CMS_RO("cmsRo"),
    ;
    private String value;

    DataSourceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
