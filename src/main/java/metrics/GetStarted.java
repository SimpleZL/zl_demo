package metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-08-03
 */
public class GetStarted {
    static final MetricRegistry metrics = new MetricRegistry();

    public static void main(String[] args) {
        startReport();
        Timer timer = metrics.timer("Test");
        Timer.Context context = timer.time();
        wait5Seconds();
        context.stop();
    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MICROSECONDS).build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(5 * 1000);
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
