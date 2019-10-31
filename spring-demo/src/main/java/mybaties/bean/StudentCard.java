package mybaties.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Data
public class StudentCard  implements Serializable {

    private static final long serialVersionUID = -961746528426401177L;
    private Integer id;
    private Integer number;
    private String address;
    private Date dateStart;
    private Date dateEnd;
    private String desc;
}
