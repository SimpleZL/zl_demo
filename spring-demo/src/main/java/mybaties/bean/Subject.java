package mybaties.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Data
public class Subject  implements Serializable {

    private static final long serialVersionUID = -8517507017613111991L;
    private int id;
    private String subjectName;
    private String descr;
}
