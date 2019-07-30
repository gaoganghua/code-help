package com.code.help.excel_test;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/*
* 生成excel
* */
public class ExcelTest {
    @Test
    public void test() throws Exception{

        // 文件输出位置
        OutputStream out = new FileOutputStream("/home/gaoganghua/桌面/aa.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet1 = new Sheet(1, 0);

        sheet1.setSheetName("第一个sheet");

        // 创建一个表格，用于 Sheet 中使用
        Table table1 = new Table(1);

        // 无注解的模式，动态添加表头
        table1.setHead(createTestListStringHead());
        // 写数据
        writer.write1(createDynamicModelList(), sheet1, table1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }

    public List<List<String>> createTestListStringHead(){
        // 模型上没有注解，表头数据动态传入
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        List<String> headCoulumn4 = new ArrayList<String>();
        List<String> headCoulumn5 = new ArrayList<String>();

        headCoulumn1.add("第一列");
        headCoulumn2.add("第2列");

        headCoulumn3.add("第二列");
        headCoulumn4.add("第三列");
        headCoulumn5.add("第一列");

        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        head.add(headCoulumn4);
        head.add(headCoulumn5);
        return head;
    }

    public List<List<Object>> createDynamicModelList(){
        List<List<Object>> rows = new ArrayList<>();

        for(int i=0;i<10;i++){
            List<Object> row = new ArrayList<>();
            row.add("a"+i);
            row.add("b"+i);
            rows.add(row);
        }
        return rows;
    }

    public static void prod(List<List<Object>> rows, List<List<String>> heads) throws Exception{

        // 文件输出位置
        OutputStream out = new FileOutputStream("/home/gaoganghua/桌面/aa.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        // 动态添加表头，适用一些表头动态变化的场景
        Sheet sheet1 = new Sheet(1, 0);

        sheet1.setSheetName("第一个sheet");

        // 创建一个表格，用于 Sheet 中使用
        Table table1 = new Table(1);

        // 无注解的模式，动态添加表头
        table1.setHead(heads);
        // 写数据
        writer.write1(rows, sheet1, table1);

        // 将上下文中的最终 outputStream 写入到指定文件中
        writer.finish();

        // 关闭流
        out.close();
    }

    public static List<List<String>> createHeads(String[] heads){
        // 模型上没有注解，表头数据动态传入
        List<List<String>> headers = new ArrayList<List<String>>();
        for(String head:heads){
            List<String> headCol = new ArrayList<String>();
            headCol.add(head);
            headers.add(headCol);
        }

        return headers;
    }

}
