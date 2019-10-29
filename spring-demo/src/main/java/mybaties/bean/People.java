package mybaties.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mybaties.enums.Sex;
import org.apache.ibatis.type.Alias;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-28
 */
@Data
@Alias(value = "people")
public class People {
    private int id;
    private String userName;
    private Sex sex;
    private String m;
}
