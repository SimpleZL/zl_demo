package com.zl.other;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-24
 */
public class T {
    public static void main(String[] args) {
        String imgaeTemplate = "<img width=\"%s\" height=\"%s\" src=\"%s\" />";
        System.out.println(String.format(imgaeTemplate, 111, 111, "http://www.nao.di.com"));
    }
}
