package zookeeper;

import com.netflix.config.DynamicStringProperty;
import com.sohu.smc.config.model.AppConfiguration;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-26
 */
public class TestAppconfiguration {
    public static void main(String[] args) {
        DynamicStringProperty testVersion = AppConfiguration.getString("smc.api.ad.versions","");
        System.out.println(testVersion.get());
    }
}
