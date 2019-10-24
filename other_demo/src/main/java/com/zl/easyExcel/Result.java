package com.zl.easyExcel;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-10-19
 */
@Data
@ToString
public class Result {
    public static int 手工网点总数量;

    public static int 人员数量1人的手工网点数量;
    public static int 人员数量2人的手工网点数量;

    public static int 配置PC的手工网点数量;
    public static int 配置手机以及PDA的手工网点数量;

    public static  HashMap<String, Integer> pc满足作业需求程度 = Maps.newHashMap();
    public static HashMap<String, Integer> pc满足管理需求程度 = Maps.newHashMap();
    public static List<String> PC端从不使用的功能包括 = Lists.newArrayList();
    public static List<String> PC端建议完善的功能包括 = Lists.newArrayList();
    public static List<String> PC端建议补充的功能包括 = Lists.newArrayList();

    public static HashMap<String, Integer> 手机满足管理需求程度 = Maps.newHashMap();
    public static HashMap<String, Integer> 手机满足作业需求程度 = Maps.newHashMap();
    public static List<String> 手机端从不使用的功能包括 = Lists.newArrayList();
    public static List<String> 手机建议完善的功能包括 = Lists.newArrayList();
    public static List<String> 手机端建议补充的功能包括 = Lists.newArrayList();

    public static HashMap<String, Integer> 操作过程中系统提示的消息易于理解程度 = Maps.newHashMap();

    public static HashMap<String, Integer> 系统出现问题后系统给出相应问题诊断的符合程度 = Maps.newHashMap();

    public static HashMap<String, Integer> 系统帮助对解决问题的帮助程度 = Maps.newHashMap();

    public static HashMap<String, Integer> 用户手册等文档对解决问题的帮助程度 = Maps.newHashMap();

    public static HashMap<String, Integer> PC端操作界面友好程度 = Maps.newHashMap();
    public static HashMap<String, Integer> 手机端操作界面友好程度 = Maps.newHashMap();

    public static  HashMap<String, Integer> 系统容易使用的程度 = Maps.newHashMap();
    public static List<String> 操作的复杂性建议 = new ArrayList<>();

    public static HashMap<String, Integer> 操作简洁程度 = Maps.newHashMap();
    public static List<String> 操作的复杂性步骤过多建议 = new ArrayList<>();

    public static List<String> 常见故障 = new ArrayList<>();
    public static int 平均系统出现故障次数;
    public static HashMap<String, Integer> 系统故障时平均持续时间 = Maps.newHashMap();
    public static HashMap<String, Integer> 对业务的影响程度 = Maps.newHashMap();
    public static List<String> 影响说明 = Lists.newArrayList();

    public static HashMap<String, Double> 人员效率 = Maps.newHashMap();

    public static HashMap<String, Integer> 总体评价 = Maps.newHashMap();
    public static List<String> 总体评价说明 = Lists.newArrayList();

    public static List<String> 意见建议 = Lists.newArrayList();


}
