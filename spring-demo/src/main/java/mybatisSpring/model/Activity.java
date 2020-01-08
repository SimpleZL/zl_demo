package mybatisSpring.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-31
 */
@Data
public class Activity {
    private Integer id;
    private Integer type;
    private Date beginTime;
    private Date endTime;
    private Integer userEverydayTimeLimit;
}
