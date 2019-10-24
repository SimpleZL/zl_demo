package com.zl.easyExcel;

import org.apache.commons.lang.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-18
 */
public class Test {
    public static void main(String[] args) {
        String ss = "人员数量1人的手工网点数量：11；人员数量2人的手工网点数量0\n";
        System.out.println(ss.replaceAll(" ",""));
    }
}
