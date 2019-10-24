package com.zl.easyExcel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-17
 */
public class ExceLService {
    public static void main(String[] args) throws IOException, InterruptedException {
        InputStream inputStream = new FileInputStream("C:\\Users\\liangzhang212928\\Desktop\\ttt.xlsx");
        File file = new File("C:\\Users\\liangzhang212928\\Desktop\\tt");
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                try {
                    inputStream = new FileInputStream(file1);
                    ExcelReader reader;
                    if (file1.getName().endsWith("xls")) {
                        reader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null, new ExcelListener());
                    } else {
                        reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new ExcelListener());
                    }
                    List<Sheet> sheets = reader.getSheets();
                    Sheet sheet = sheets.get(0);
                    sheet.setClazz(SimpleAssetsOperational.class);
                    reader.read(sheet);
                    inputStream.close();
                } catch ( Exception e ) {
                    System.out.println(file1.getName());
//                    e.printStackTrace();
                }

            }
        }
//        ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new ExcelListener());
//        List<Sheet> sheets = reader.getSheets();
//        Sheet sheet = sheets.get(0);
//        sheet.setClazz(SimpleAssetsOperational.class);
//        reader.read(sheet);
        Thread.sleep(10 * 1000);

        System.out.println("统计信息如下： ");
        System.out.println(String.format("手工网点总数量:%s", Result.手工网点总数量));
        System.out.println(String.format("人员数量1人的手工网点数量:%s", Result.人员数量1人的手工网点数量));
        System.out.println(String.format("人员数量2人的手工网点数量:%s", Result.人员数量2人的手工网点数量));
        System.out.println(String.format("配置PC的手工网点数量:%s", Result.配置PC的手工网点数量));
        System.out.println(String.format("配置手机以及PDA的手工网点数量:%s", Result.配置手机以及PDA的手工网点数量));

        HashMap<String, Integer> pc满足作业需求程度 = Result.pc满足作业需求程度;
        System.out.println("===========pc满足作业需求程度统计信息================");
        for (String key : pc满足作业需求程度.keySet()) {
            System.out.println(String.format("%s : %s", key, pc满足作业需求程度.get(key)));
        }

        HashMap<String, Integer> pc满足管理需求程度 = Result.pc满足管理需求程度;
        System.out.println("===========pc满足管理需求程度================");
        for (String key : pc满足管理需求程度.keySet()) {
            System.out.println(String.format("%s : %s", key, pc满足管理需求程度.get(key)));
        }

        List<String> pc端从不使用的功能包括 = Result.PC端从不使用的功能包括;
        System.out.println("======PC端从不使用的功能包括=====");
        for (String s : pc端从不使用的功能包括) {
            System.out.println(s);
        }

        List<String> PC端建议完善的功能包括 = Result.PC端建议完善的功能包括;
        System.out.println("======PC端建议完善的功能包括=====");
        for (String s : PC端建议完善的功能包括) {
            System.out.println(s);
        }


        List<String> PC端建议补充的功能包括 = Result.PC端建议补充的功能包括;
        System.out.println("======PC端建议补充的功能包括=====");
        for (String s : PC端建议补充的功能包括) {
            System.out.println(s);
        }


        HashMap<String, Integer> 手机满足管理需求程度 = Result.手机满足管理需求程度;
        System.out.println("===========手机满足管理需求程度================");
        for (String key : 手机满足管理需求程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 手机满足管理需求程度.get(key)));
        }

        HashMap<String, Integer> 手机满足作业需求程度 = Result.手机满足作业需求程度;
        System.out.println("===========手机满足作业需求程度================");
        for (String key : 手机满足作业需求程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 手机满足作业需求程度.get(key)));
        }

        List<String> 手机端从不使用的功能包括 = Result.手机端从不使用的功能包括;
        System.out.println("======手机端从不使用的功能包括=====");
        for (String s : 手机端从不使用的功能包括) {
            System.out.println(s);
        }

        List<String> 手机建议完善的功能包括 = Result.手机建议完善的功能包括;
        System.out.println("======手机建议完善的功能包括=====");
        for (String s : 手机建议完善的功能包括) {
            System.out.println(s);
        }

        List<String> 手机端建议补充的功能包括 = Result.手机端建议补充的功能包括;
        System.out.println("======手机端从不使用的功能包括=====");
        for (String s : 手机端从不使用的功能包括) {
            System.out.println(s);
        }

        HashMap<String, Integer> 操作过程中系统提示的消息易于理解程度 = Result.操作过程中系统提示的消息易于理解程度;
        System.out.println("===========操作过程中系统提示的消息易于理解程度================");
        for (String key : 操作过程中系统提示的消息易于理解程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 操作过程中系统提示的消息易于理解程度.get(key)));
        }
        HashMap<String, Integer> 系统出现问题后系统给出相应问题诊断的符合程度 = Result.系统出现问题后系统给出相应问题诊断的符合程度;
        System.out.println("===========系统出现问题后系统给出相应问题诊断的符合程度================");
        for (String key : 系统出现问题后系统给出相应问题诊断的符合程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 系统出现问题后系统给出相应问题诊断的符合程度.get(key)));
        }

        HashMap<String, Integer> 系统帮助对解决问题的帮助程度 = Result.系统帮助对解决问题的帮助程度;
        System.out.println("===========系统帮助对解决问题的帮助程度================");
        for (String key : 系统帮助对解决问题的帮助程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 操作过程中系统提示的消息易于理解程度.get(key)));
        }

        HashMap<String, Integer> 用户手册等文档对解决问题的帮助程度 = Result.用户手册等文档对解决问题的帮助程度;
        System.out.println("===========用户手册等文档对解决问题的帮助程度================");
        for (String key : 用户手册等文档对解决问题的帮助程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 用户手册等文档对解决问题的帮助程度.get(key)));
        }


        HashMap<String, Integer> PC端操作界面友好程度 = Result.PC端操作界面友好程度;
        System.out.println("===========PC端操作界面友好程度================");
        for (String key : PC端操作界面友好程度.keySet()) {
            System.out.println(String.format("%s : %s", key, PC端操作界面友好程度.get(key)));
        }

        HashMap<String, Integer> 手机端操作界面友好程度 = Result.手机端操作界面友好程度;
        System.out.println("===========手机端操作界面友好程度================");
        for (String key : 手机端操作界面友好程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 手机端操作界面友好程度.get(key)));
        }

        HashMap<String, Integer> 系统容易使用的程度 = Result.系统容易使用的程度;
        System.out.println("===========系统容易使用的程度================");
        for (String key : 系统容易使用的程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 系统容易使用的程度.get(key)));
        }


        List<String> 操作的复杂性建议 = Result.操作的复杂性建议;
        System.out.println("======操作的复杂性建议=====");
        for (String s : 操作的复杂性建议) {
            System.out.println(s);
        }

        HashMap<String, Integer> 操作简洁程度 = Result.操作简洁程度;
        System.out.println("===========操作简洁程度================");
        for (String key : 操作简洁程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 操作简洁程度.get(key)));
        }

        List<String> 操作的复杂性步骤过多建议 = Result.操作的复杂性步骤过多建议;
        System.out.println("======操作的复杂性步骤过多建议=====");
        for (String s : 操作的复杂性步骤过多建议) {
            System.out.println(s);
        }

        List<String> 常见故障 = Result.常见故障;
        System.out.println("======常见故障=====");
        for (String s : 常见故障) {
            System.out.println(s);
        }


        System.out.println(String.format("平均系统出现故障次数:%s", Result.平均系统出现故障次数));

        HashMap<String, Integer> 系统故障时平均持续时间 = Result.系统故障时平均持续时间;
        System.out.println("===========系统故障时平均持续时间================");
        for (String key : 系统故障时平均持续时间.keySet()) {
            System.out.println(String.format("%s : %s", key, 系统故障时平均持续时间.get(key)));
        }

        HashMap<String, Integer> 对业务的影响程度 = Result.对业务的影响程度;
        System.out.println("===========对业务的影响程度================");
        for (String key : 对业务的影响程度.keySet()) {
            System.out.println(String.format("%s : %s", key, 对业务的影响程度.get(key)));
        }

        List<String> 影响说明 = Result.影响说明;
        System.out.println("======影响说明=====");
        for (String s : 影响说明) {
            System.out.println(s);
        }


        HashMap<String, Double> 人员效率 = Result.人员效率;
        System.out.println("===========人员效率================");
        for (String key : 人员效率.keySet()) {
            System.out.println(String.format("%s : %s", key, 人员效率.get(key)));
        }

        HashMap<String, Integer> 总体评价 = Result.总体评价;
        System.out.println("===========总体评价================");
        for (String key : 总体评价.keySet()) {
            System.out.println(String.format("%s : %s", key, 总体评价.get(key)));
        }

        List<String> 总体评价说明 = Result.总体评价说明;
        System.out.println("======总体评价说明=====");
        for (String s : 总体评价说明) {
            System.out.println(s);
        }

        List<String> 意见建议 = Result.意见建议;
        System.out.println("======意见建议=====");
        for (String s : 意见建议) {
            System.out.println(s);
        }


    }
}
