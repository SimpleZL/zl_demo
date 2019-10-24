package com.zl.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-21
 */
@Getter
@Setter
public class TestBuilderMethod {
    private String id;
    @Builder
    public static  void test(){

    }
}
