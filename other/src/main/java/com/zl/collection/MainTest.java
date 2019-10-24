package com.zl.collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-14
 */
public class MainTest {
    public static void main(String[] args) {
        int reslut = 0;
        int i = 0;
        int n = 2;
        do {
            if ((n & 1) == 1) {
                reslut++;
            }
            n >>= 1;
            i++;
        } while (i < 32);
        System.out.println(reslut);
    }
}
