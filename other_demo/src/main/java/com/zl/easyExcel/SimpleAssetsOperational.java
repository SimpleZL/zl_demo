package com.zl.easyExcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2018-12-17
 */
@Data
public class SimpleAssetsOperational extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String param;
    @ExcelProperty(index = 1)
    private String content;
    @ExcelProperty(index = 2)
    private String des;


}
