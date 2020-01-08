package mybatisSpring.aop;

import mybatisSpring.annotation.DataSource;
import mybatisSpring.conf.MomentRoutingDataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-12-30
 */
@Aspect
@Component
@Order(0)
public class CustomDataSourceAspect {
    // @annotation(mybatisSpring.annotation.DataSource) &&
    @Pointcut(value = "execution( * mybatisSpring.dao..*.*(..))")
    public void pointCut() {

    }

    @Before(value = "pointCut()")
    public void changeDataSource(JoinPoint joinPoint) throws NoSuchMethodException {
        Class<?> aClass = joinPoint.getTarget().getClass();
        //拦截mapper方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method != null && method.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = method.getAnnotation(DataSource.class);
            MomentRoutingDataSource.setDataSource(dataSource.type());
            System.out.println("Service Class 数据源切换至--->" + dataSource.type().getValue());
            return;
        }
        //拦截mapper类
        if (aClass.isAnnotationPresent(DataSource.class)) {
            DataSource dataSource = aClass.getAnnotation(DataSource.class);
            MomentRoutingDataSource.setDataSource(dataSource.type());
            System.out.println("Service Class 数据源切换至--->" + dataSource.type().getValue());
            return;
        }

    }

    /**
     * 方法结束后
     */
    @After(value = "pointCut()")
    public void afterReturning() throws Throwable {
        try {
            MomentRoutingDataSource.clear();
            System.out.println("数据源已移除！");
        } catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("数据源移除报错！");
        }

    }
}
