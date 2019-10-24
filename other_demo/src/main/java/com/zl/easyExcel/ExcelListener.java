package com.zl.easyExcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Excel解析类
 *
 * @author liangzhang212928
 */
public class ExcelListener extends AnalysisEventListener<SimpleAssetsOperational> {
    private String 五星 = "五星■";
    private String 四星 = "四星■";
    private String 三星 = "三星■";
    private String 二星 = "二星■";
    private String 一星 = "一星■";
    private List<SimpleAssetsOperational> datas = new ArrayList<SimpleAssetsOperational>();
    private int index = 0;

    public List<SimpleAssetsOperational> getDatas() {
        return datas;
    }

    public void setDatas(List<SimpleAssetsOperational> datas) {
        this.datas = datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO Auto-generated method stub

    }

    @Override
    public void invoke(SimpleAssetsOperational simpleAssetsOperational, AnalysisContext context) {
        // TODO Auto-generated method stub
        String des = simpleAssetsOperational.getDes();
        if (StringUtils.isBlank(des)) {
            ++index;
            return;
        }

        String replace2 = des.replace("\n", "");
        String replace = replace2.replace(" ", "");
        switch (index) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                // 单位名称：定远县分公司              填表人员姓名：吴松       联系方式：18955083799
                break;
            case 3:
                //手工网点总数量
                String var111 = replace.replace("个","");
                if (StringUtils.isNotBlank(var111)){
                    int i = Integer.parseInt(var111);
                    Result.手工网点总数量 += i;
                }
                break;
            case 4:
                //手工网点人员  人员数量1人的手工网点数量：   11  ；人员数量2人的手工网点数量    0  人员数量1人的手工网点数量：11；人员数量2人的手工网点数量0
                String[] strings = replace.split("；");
                for (String info : strings) {
                    if (info.contains("人员数量1人的手工网点数量")) {
                        String replace1 = info.replace("：", "");
                        String 人员数量1人的手工网点数量 = replace1.replace("人员数量1人的手工网点数量", "");
                        if (StringUtils.isNotBlank(人员数量1人的手工网点数量)) {
                            int i1 = Integer.parseInt(人员数量1人的手工网点数量.replace("个",""));
                            Result.人员数量1人的手工网点数量 += i1;
                        }
                    } else if (info.contains("人员数量2人的手工网点数量")) {
                        String replace1 = info.replace("：", "");
                        String 人员数量2人的手工网点数量 = replace1.replace("人员数量2人的手工网点数量", "");
                        if (StringUtils.isNotBlank(人员数量2人的手工网点数量)) {
                            int i1 = Integer.parseInt(人员数量2人的手工网点数量.replace("个",""));
                            Result.人员数量2人的手工网点数量 += i1;
                        }
                    }
                }
                break;
            case 5:
                //设备配备 （PC/手机/PDA） 配置PC的手工网点数量：  2  ；配置手机以及PDA的手工网点数量：  9
                String[] stringss = replace.split("；");
                for (String info : stringss) {
                    if (info.contains("配置PC的手工网点数量")) {
                        String replace1 = info.replace("：", "");
                        String 配置PC的手工网点数量 = replace1.replace("配置PC的手工网点数量", "");
                        if (StringUtils.isNotBlank(配置PC的手工网点数量)) {
                            int i1 = Integer.parseInt(配置PC的手工网点数量.replace("个",""));
                            Result.配置PC的手工网点数量 += i1;
                        }
                    } else if (info.contains("配置手机以及PDA的手工网点数量")) {
                        String replace1 = info.replace("：", "");
                        String 配置手机以及PDA的手工网点数量 = replace1.replace("配置手机以及PDA的手工网点数量", "");
                        if (StringUtils.isNotBlank(配置手机以及PDA的手工网点数量)) {
                            int i1 = Integer.parseInt(配置手机以及PDA的手工网点数量.replace("个",""));
                            Result.配置手机以及PDA的手工网点数量 += i1;
                        }
                    }
                }
                break;
            case 6:
                //满足作业需求程度：五星■  四星□  三星□  二星□  一星□
                //（备注：在所选星数后面涂黑■，星数越多，说明程度越大或评价越高，以下均是如此）
                //满足管理需求程度：五星■  四星□  三星□  二星□  一星□；
                //从不使用的功能包括：                                 ；
                //建议完善的功能包括：                                 ；
                //建议补充的功能包括：                                 ；
                String[] split = replace.split("；");
                if (split.length >= 4) {
                    int length = split[0].length();
                    int index = split[0].indexOf("如此");
                    String 选项1 = split[0].substring(0, index);
                    String 选项2 = split[0].substring(index, length);
                    String 星 = xuanxing(选项1);
                    HashMap<String, Integer> pc满足作业需求程度 = Result.pc满足作业需求程度;
                    if (pc满足作业需求程度.containsKey(星)) {
                        Integer integer = pc满足作业需求程度.get(星);
                        pc满足作业需求程度.put(星, ++integer);
                    } else {
                        pc满足作业需求程度.put(星, 1);
                    }

                    Result.pc满足作业需求程度 = pc满足作业需求程度;
                    星 = xuanxing(选项2);
                    HashMap<String, Integer> pc满足管理需求程度 = Result.pc满足管理需求程度;
                    if (pc满足管理需求程度.containsKey(星)) {
                        Integer integer = pc满足管理需求程度.get(星);
                        pc满足管理需求程度.put(星, ++integer);
                    } else {
                        pc满足管理需求程度.put(星, 1);
                    }
                    Result.pc满足管理需求程度 = pc满足管理需求程度;
                    // -------2
                    String s2 = split[1];
                    String var2 = s2.replace("从不使用的功能包括：", "");
                    if (StringUtils.isNotBlank(var2)) {
                        Result.PC端从不使用的功能包括.add(var2);
                    }

                    // -------3
                    String s3 = split[2];
                    String var3 = s3.replace("建议完善的功能包括：", "");
                    if (StringUtils.isNotBlank(var3)) {
                        Result.PC端建议完善的功能包括.add(var3);
                    }

                    // -------2
                    String s4 = split[3];
                    String var4 = s4.replace("建议补充的功能包括：", "");
                    if (StringUtils.isNotBlank(var4)) {
                        Result.PC端建议补充的功能包括.add(var4);
                    }
                } else {
                   throw new NullPointerException();
                }


                break;
            case 7:
                //满足作业需求程度：五星■  四星□  三星□  二星□  一星□；
                //满足管理需求程度：五星■  四星□  三星□  二星□  一星□；
                //从不使用的功能包括：                                 ；
                //建议完善的功能包括：                                 ；
                //建议补充的功能包括：                                 ；

                String[] split8 = replace.split("；");
                if (split8.length >= 5) {
                    String 星 = xuanxing(split8[0]);
                    HashMap<String, Integer> 手机满足作业需求程度 = Result.手机满足作业需求程度;
                    if (手机满足作业需求程度.containsKey(星)) {
                        Integer integer = 手机满足作业需求程度.get(星);
                        手机满足作业需求程度.put(星, ++integer);
                    } else {
                        手机满足作业需求程度.put(星, 1);
                    }
                    Result.手机满足作业需求程度 = 手机满足作业需求程度;
                    // 2
                    星 = xuanxing(split8[1]);
                    HashMap<String, Integer> 手机满足管理需求程度 = Result.手机满足管理需求程度;
                    if (手机满足管理需求程度.containsKey(星)) {
                        Integer integer = 手机满足管理需求程度.get(星);
                        手机满足管理需求程度.put(星, ++integer);
                    } else {
                        手机满足管理需求程度.put(星, 1);
                    }
                    Result.手机满足管理需求程度 = 手机满足管理需求程度;
                    // -------3
                    String s2 = split8[2];
                    String var2 = s2.replace("从不使用的功能包括：", "");
                    if (StringUtils.isNotBlank(var2)) {
                        Result.手机端从不使用的功能包括.add(var2);
                    }

                    // -------3
                    String s3 = split8[3];
                    String var3 = s3.replace("建议完善的功能包括：", "");
                    if (StringUtils.isNotBlank(var3)) {
                        Result.手机建议完善的功能包括.add(var3);
                    }

                    // -------2
                    String s4 = split8[4];
                    String var4 = s4.replace("建议补充的功能包括：", "");
                    if (StringUtils.isNotBlank(var4)) {
                        Result.手机端建议补充的功能包括.add(var4);
                    }
                } else {
                    throw new NullPointerException();
                }
                break;
            case 8:
                // 操作过程中系统提示的消息易于理解程度：
                //五星■  四星□  三星□  二星□  一星□；
                String 星 = xuanxing(replace);
                HashMap<String, Integer> 操作过程中系统提示的消息易于理解程度 = Result.操作过程中系统提示的消息易于理解程度;
                if (操作过程中系统提示的消息易于理解程度.containsKey(星)) {
                    int var = 操作过程中系统提示的消息易于理解程度.get(星);
                    操作过程中系统提示的消息易于理解程度.put(星, ++var);
                } else {
                    操作过程中系统提示的消息易于理解程度.put(星, 1);
                }
                Result.操作过程中系统提示的消息易于理解程度 = 操作过程中系统提示的消息易于理解程度;
                break;
            case 9:
                //系统出现问题后，系统给出相应问题诊断的符合程度：
                //五星■   四星□  三星□  二星□  一星□；
                String 星10 = xuanxing(replace);
                HashMap<String, Integer> 系统出现问题后系统给出相应问题诊断的符合程度 = Result.系统出现问题后系统给出相应问题诊断的符合程度;
                if (系统出现问题后系统给出相应问题诊断的符合程度.containsKey(星10)) {
                    int var = 系统出现问题后系统给出相应问题诊断的符合程度.get(星10);
                    系统出现问题后系统给出相应问题诊断的符合程度.put(星10, ++var);
                } else {
                    系统出现问题后系统给出相应问题诊断的符合程度.put(星10, 1);
                }
                Result.系统出现问题后系统给出相应问题诊断的符合程度 = 系统出现问题后系统给出相应问题诊断的符合程度;
                break;
            case 10:
                //系统帮助对解决问题的帮助程度：
                //五星■  四星□  三星□  二星□  一星□；
                String 星11 = xuanxing(replace);
                HashMap<String, Integer> 系统帮助对解决问题的帮助程度 = Result.系统帮助对解决问题的帮助程度;
                if (系统帮助对解决问题的帮助程度.containsKey(星11)) {
                    int var = 系统帮助对解决问题的帮助程度.get(星11);
                    系统帮助对解决问题的帮助程度.put(星11, ++var);
                } else {
                    系统帮助对解决问题的帮助程度.put(星11, 1);
                }
                Result.系统帮助对解决问题的帮助程度 = 系统帮助对解决问题的帮助程度;

                break;
            case 11:
                //用户手册等文档对解决问题的帮助程度：
                //五星■  四星□  三星□  二星□  一星□；
                String 星12 = xuanxing(replace);
                HashMap<String, Integer> 用户手册等文档对解决问题的帮助程度 = Result.用户手册等文档对解决问题的帮助程度;
                if (用户手册等文档对解决问题的帮助程度.containsKey(星12)) {
                    int var = 用户手册等文档对解决问题的帮助程度.get(星12);
                    用户手册等文档对解决问题的帮助程度.put(星12, ++var);
                } else {
                    用户手册等文档对解决问题的帮助程度.put(星12, 1);
                }
                Result.用户手册等文档对解决问题的帮助程度 = 用户手册等文档对解决问题的帮助程度;
                break;
            case 12:
                //PC端操作界面友好程度：五星■ 四星□  三星□  二星□  一星□；
                //APP操作界面友好程度： 五星■  四星□  三星□  二星□  一星□；
                String[] s_13 = replace.split("；");
                int lenght = s_13.length;
                if (lenght >= 2) {
                    String PC端操作界面友好程度 = s_13[0];
                    HashMap<String, Integer> pc端操作界面友好程度 = Result.PC端操作界面友好程度;
                    String var = xuanxing(PC端操作界面友好程度);
                    if (pc端操作界面友好程度.containsKey(var)) {
                        int _v = pc端操作界面友好程度.get(var);
                        pc端操作界面友好程度.put(var, ++_v);
                    } else {
                        pc端操作界面友好程度.put(var, 1);
                    }
                    Result.PC端操作界面友好程度 = pc端操作界面友好程度;

                    String APP操作界面友好程度 = s_13[1];
                    HashMap<String, Integer> 手机端操作界面友好程度 = Result.手机端操作界面友好程度;
                    String var1 = xuanxing(APP操作界面友好程度);
                    if (手机端操作界面友好程度.containsKey(var1)) {
                        int _v = 手机端操作界面友好程度.get(var1);
                        手机端操作界面友好程度.put(var1, ++_v);
                    } else {
                        手机端操作界面友好程度.put(var1, 1);
                    }
                    Result.手机端操作界面友好程度 = 手机端操作界面友好程度;

                } else {
                    throw new NullPointerException();
                }
                break;
            case 13:
                //系统容易使用的程度：五星■  四星□  三星□  二星□  一星□；
                //若感觉到复杂，优化建议：                                 ；
                String[] s_14 = replace.split("；");
                int lenght14 = s_14.length;
                if (lenght14 >= 2) {
                    String ss = s_14[0];
                    HashMap<String, Integer> 系统容易使用的程度 = Result.系统容易使用的程度;
                    String var = xuanxing(ss);
                    if (系统容易使用的程度.containsKey(var)) {
                        int _v = 系统容易使用的程度.get(var);
                        系统容易使用的程度.put(var, ++_v);
                    } else {
                        系统容易使用的程度.put(var, 1);
                    }
                    Result.系统容易使用的程度 = 系统容易使用的程度;

                    String 优化建议 = s_14[1];
                    Result.操作的复杂性建议.add(优化建议.replace("若感觉到复杂，优化建议：", ""));

                } else {
                    throw new NullPointerException();
                }
                break;
            case 14:
                //完成具体任务时的操作简洁程度（操作步骤少）：
                //五星■   四星□  三星□  二星□  一星□；
                //若感觉到操作步骤过多，优化建议：                         ；
                String[] s_15 = replace.split("；");
                int lenght15 = s_15.length;
                if (lenght15 >= 2) {
                    String ss = s_15[0];
                    HashMap<String, Integer> 操作简洁程度 = Result.操作简洁程度;
                    String var = xuanxing(ss);
                    if (操作简洁程度.containsKey(var)) {
                        int _v = 操作简洁程度.get(var);
                        操作简洁程度.put(var, ++_v);
                    } else {
                        操作简洁程度.put(var, 1);
                    }
                    Result.系统容易使用的程度 = 操作简洁程度;

                    String 优化建议 = s_15[1];
                    Result.操作的复杂性步骤过多建议.add(优化建议.replace("若感觉到操作步骤过多，优化建议：", ""));

                } else {
                    System.out.println("解析异常15");
                }
                break;
            case 15:
                //常见故障名称（或类型）：                                                        ；
                //系统平均每个月出现的故障次数：  1  次；
                //系统故障时平均持续时间：
                //30分钟内■ 1小时内□  2小时内□  2小时以上□；
                //对业务的影响程度：五星□  四星□  三星□  二星□  一星□；
                //（备注：星数越多，说明影响程度越大）
                //若有影响，请简要说明：
                String[] s_16 = replace.split("；");
                if (s_16.length >= 5) {
                    String s1 = s_16[0];
                    Result.常见故障.add(s1.replace("常见故障名称（或类型）：", ""));

                    String s2 = s_16[1];
                    String replace1 = s2.replace("系统平均每个月出现的故障次数：", "");
                    String 次 = replace1.replace("次", "");
                    if (StringUtils.isNotBlank(次)){
                        int i1 = 0;
                        if (次.contains("-")){
                            i1 = Integer.parseInt(次.split("-")[0]);
                        }else {
                            i1 = Integer.parseInt(次);
                        }
                        Result.平均系统出现故障次数 += i1;
                    }


                    String s3  = s_16[2];
                    String xuanxiaoshi = xuanxiaoshi(s3);
                    if (Result.系统故障时平均持续时间.containsKey(xuanxiaoshi)) {
                        int count = Result.系统故障时平均持续时间.get(xuanxiaoshi);
                        Result.系统故障时平均持续时间.put(xuanxiaoshi,++count);
                    }else {
                        Result.系统故障时平均持续时间.put(xuanxiaoshi,1);
                    }

                    String s4  = s_16[3];
                    String xing = xuanxing(s4);
                    if (Result.对业务的影响程度.containsKey(xing)) {
                        int count = Result.对业务的影响程度.get(xing);
                        Result.对业务的影响程度.put(xing,++count);
                    }else {
                        Result.对业务的影响程度.put(xing,1);
                    }

                    String s5 = s_16[4];
                    Result.影响说明.add(s5.replace("（备注：星数越多，说明影响程度越大）若有影响，请简要说明：", ""));

                }
                break;
            case 16:
                //系统运行前手工作业效率：   10    分钟/每件（普通包裹）
                //系统运行前手工作业效率：   5    分钟/每件（信函）
                //系统运行前手工作业效率：   3    分钟/每件（报刊）；
                //系统运行后作业效率：   8    分钟/每件（普通包裹）
                //系统运行后作业效率：   4    分钟/每件（信函）
                //系统运行后作业效率：   3    分钟/每件（报刊）。
                String[] s_17 = replace.split("；");
                if (s_17.length >= 2){
                    String[] s_var = s_17[0].split("）");
                    if (s_var.length >= 3){
                        // 1
                        String replace1 = s_var[0].replace("系统运行前手工作业效率：", "");
                        String replace3 = replace1.replace("分钟/每件（普通包裹", "");
                        double result = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("普通包裹")) {
                            Double var = Result.人员效率.get("普通包裹");
                            Result.人员效率.put("普通包裹",result+var);
                        }else {
                            Result.人员效率.put("普通包裹",result);
                        }
                        //2
                        replace1 = s_var[1].replace("系统运行前手工作业效率：", "");
                        replace3 = replace1.replace("分钟/每件（信函", "");
                        double result1 = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result1 = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("信函")) {
                            Double var = Result.人员效率.get("信函");
                            Result.人员效率.put("信函",result1+var);
                        }else {
                            Result.人员效率.put("信函",result1);
                        }
                        //3
                        replace1 = s_var[2].replace("系统运行前手工作业效率：", "");
                        replace3 = replace1.replace("分钟/每件（报刊", "");
                        double result3 = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result3 = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("报刊")) {
                            Double var = Result.人员效率.get("报刊");
                            Result.人员效率.put("报刊",result3+var);
                        }else {
                            Result.人员效率.put("报刊",result3);
                        }
                    }


                    s_var = s_17[1].split("）");
                    if (s_var.length >= 3){
                        // 1
                        String replace1 = s_var[0].replace("系统运行后作业效率：", "");
                        String replace3 = replace1.replace("分钟/每件（普通包裹", "");
                        double result4 = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result4 = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("系统运行后普通包裹")) {
                            Double var = Result.人员效率.get("系统运行后普通包裹");
                            Result.人员效率.put("系统运行后普通包裹",result4+var);
                        }else {
                            Result.人员效率.put("系统运行后普通包裹",result4);
                        }
                        //2

                        replace1 = s_var[1].replace("系统运行后作业效率：", "");
                        replace3 = replace1.replace("分钟/每件（信函", "");
                        double result5 = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result5 = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("系统运行后信函")) {
                            Double var = Result.人员效率.get("系统运行后信函");
                            Result.人员效率.put("系统运行后信函",result5+var);
                        }else {
                            Result.人员效率.put("系统运行后信函",result5);
                        }
                        //3
                        replace1 = s_var[2].replace("系统运行后作业效率：", "");
                        replace3 = replace1.replace("分钟/每件（报刊", "");
                        double result6 = 0;
                        if (StringUtils.isNotBlank(replace3)){
                            result6 = Double.parseDouble(replace3);
                        }
                        if (Result.人员效率.containsKey("系统运行后报刊")) {
                            Double var = Result.人员效率.get("系统运行后报刊");
                            Result.人员效率.put("系统运行后报刊",result6+var);
                        }else {
                            Result.人员效率.put("系统运行后报刊",result6);
                        }
                    }


                }
                break;
            case 17:
                //您对系统的总体评价：五星■  四星□  三星□  二星□  一星□；
                //简要评价说明：
                String[] s_18 = replace.split("；");
                int lenght18 = s_18.length;
                if (lenght18 >= 2) {
                    String ss = s_18[0];
                    HashMap<String, Integer> 总体评价 = Result.总体评价;
                    String var = xuanxing(ss);
                    if (总体评价.containsKey(var)) {
                        int _v = 总体评价.get(var);
                        总体评价.put(var, ++_v);
                    } else {
                        总体评价.put(var, 1);
                    }
                    Result.总体评价 = 总体评价;

                    String 优化建议 = s_18[1];

                    Result.总体评价说明.add(优化建议.replace("简要评价说明：", ""));

                } else {
                    throw new NullPointerException();
                }
                break;
            case 18:
                //意见建议
                Result.意见建议.add(replace);
                break;
            default:
        }
        ++index;
    }

    private String xuanxing(String s) {
        if (s.contains(五星)) {
            return 五星;
        }
        if (s.contains(四星)) {
            return 四星;
        }
        if (s.contains(三星)) {
            return 三星;
        }
        if (s.contains(二星)) {
            return 二星;
        }
        if (s.contains(一星)) {
            return 一星;
        }
        return 五星;
    }

    private String xuanxiaoshi(String s) {
        if (s.contains("30分钟内■")) {
            return "30分钟内■";
        }
        if (s.contains("1小时内■")) {
            return "1小时内■";
        }
        if (s.contains("2小时内■")) {
            return "2小时内■";
        }
        if (s.contains("2小时以上■")) {
            return "2小时以上■";
        }
        return "30分钟内■";
    }
}
