package demo.xml;

import com.alibaba.dubbo.config.annotation.Reference;
import demo.xml.api.EchoService;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-24
 */
@Component
public class EchoConsumer {
    @Reference
    private EchoService echoService;
    public String echo(String name){
      return   echoService.echo(name);
    }
}
