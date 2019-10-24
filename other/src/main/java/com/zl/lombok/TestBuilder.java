package com.zl.lombok;

import lombok.Builder;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-21
 */
@Builder
public class TestBuilder {
    private String id;
    private String name;
    @Builder.Default private long ts = System.currentTimeMillis();
}
