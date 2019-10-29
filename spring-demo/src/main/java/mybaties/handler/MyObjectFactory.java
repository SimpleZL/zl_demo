package mybaties.handler;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-29
 */
public class MyObjectFactory extends DefaultObjectFactory {
    private Logger logger = LoggerFactory.getLogger(DefaultObjectFactory.class);

    /**
     * Sets configuration properties.
     *
     * @param properties configuration properties
     */
    @Override
    public void setProperties(Properties properties) {
        logger.info("myObjectFactory属性信息:" + properties);
        super.setProperties(properties);
    }

    @Override
    public <T> T create(Class<T> type) {
        logger.info("定制属性：" + type.getName());
        return super.create(type);
    }
}
