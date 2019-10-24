package com.zl.redis;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-02-28
 */
@Data
public class Bill {
    private int id;
    private int fee;
    private int activityId;
    private String activityName;
}
