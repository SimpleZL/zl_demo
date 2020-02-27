package demo.xml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2020-02-24
 */
public class ConsumerTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConsuner.class);
        context.start();
        EchoConsumer echoConsumer = context.getBean(EchoConsumer.class);
        String hell_word = echoConsumer.echo("hell word");
        System.out.println(hell_word);
    }
}
