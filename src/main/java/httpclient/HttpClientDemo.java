package httpclient;

import java_demo.VideoItem.NewsTVInfoDO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 同步的http请求
 *
 * @author: liangzhang212928
 * @Date: 2018-08-14
 */
public class HttpClientDemo {
    public static void test(){
        try {
            Thread.sleep(1000);
            return;
        }catch ( Exception e ){
            System.out.println(e);
        }finally {
            System.out.println("S");
        }
    }
    public static  void test1(){
        final NewsTVInfoDO newsTVInfoDO = new NewsTVInfoDO();
        System.out.println(newsTVInfoDO.hashCode());
    }




    public static void main(String[] args) {
        test1();
        test1();
    }
}
