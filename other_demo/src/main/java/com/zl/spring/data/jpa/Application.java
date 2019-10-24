package com.zl.spring.data.jpa;

import com.zl.spring.data.jpa.model.VerityCertModel;
import com.zl.spring.data.jpa.repository.VerifyCertDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-10
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DataSourceConf.class);
        VerifyCertDao verifyCertDao = applicationContext.getBean("verifyCertDao", VerifyCertDao.class);
        VerityCertModel verityCertModel = verifyCertDao.findById(1).get();
        System.out.println(verityCertModel);

    }
}
