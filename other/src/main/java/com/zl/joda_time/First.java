package com.zl.joda_time;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-07-02
 */
public class First {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime();
        DateTime dateTime1 = new DateTime(System.currentTimeMillis());
        System.out.println(dateTime.dayOfMonth().get());
    }
}
