package mybatisSpring.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * here we use @CustomMaster annotation to indicate that the method which is annotated by @CustomMaster
 * will read or write the record form master dataSource
 *
 * @author: liangzhang212928
 * @Date: 2019-12-30
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    DataSourceType type() default DataSourceType.CMS_RO;
}
