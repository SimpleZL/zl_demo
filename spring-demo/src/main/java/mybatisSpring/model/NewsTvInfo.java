package mybaties.bean;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-26
 */
@Data
public class NewsTvInfo {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String source;
    private Integer vid;
    private String bigPic;
    private String playUrl;
    private String urlHigh;
    private String urlNor;
    private Integer fileSizeHigh;
    private Integer fileSizeNor;
    private Integer playTime;
    private Integer bindNewsId;
    private Date applicationTime;
    private String bindPosition;
    private String urlDivision;
    private String guid;
    private String sourceSite;
    private Integer site;
    private Date createTime;
    private Date updateTime;
    private Integer forwardVideo;
}
