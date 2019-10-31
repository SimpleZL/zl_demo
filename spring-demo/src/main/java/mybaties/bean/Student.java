package mybaties.bean;

import lombok.Data;
import mybaties.enums.Sex;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-30
 */
@Data
public class Student implements Serializable {

    private static final long serialVersionUID = -5875471618766826709L;
    private int id;
    private String name;
    private Sex sex;
    private StudentCard studentCard;
    private String desc;
    private List<SubjectCore> subjectList;
}
