package mybaties.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Data
public class SubjectCore implements Serializable {

    private static final long serialVersionUID = -5302917198308625237L;
    private int id;
    private int number;
    private Subject subject;
    private BigDecimal score;
    private String decrc;
}
