package com.code.help.table_to_bean.main;

import com.code.help.table_to_bean.bean.BeanDefine;
import com.code.help.table_to_bean.bean.TableMapping;
import com.code.help.table_to_bean.enums.TypeMappingEnum;
import com.code.help.util.FileUtils;
import com.mysql.cj.protocol.Resultset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

@Service
public class GenerateMapping {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TableMapping tableMapping;

    private final String DEFAULT_DIR = "/Users/chancelee/Desktop/DEFAULT/table_bean";

    public void generate() throws SQLException, IOException, ClassNotFoundException {
        File dirFile = FileUtils.getFileByName(tableMapping.getTargetDir(), DEFAULT_DIR);
        String daoPackage = tableMapping.getDaoPackage();
        String beanPackage = tableMapping.getBeanPackage();

        File outFile = FileUtils.getFileByDirAndName(dirFile, "mapp.txt");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));

        for (BeanDefine beanDefine : tableMapping.getBeanDefines()) {
            generateMapping(beanDefine, bos);
        }
        bos.close();
    }

    public void generateMapping(BeanDefine beanDefine, BufferedOutputStream bos) throws IOException, SQLException {
        long startTime = System.currentTimeMillis();

        DatabaseMetaData databaseMetaData = dataSource.getConnection().getMetaData();
        ResultSet rs = databaseMetaData.getColumns(null, "%", beanDefine.getTabName(), "%");
//        PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from "+beanDefine.getTabName());
//        ResultSetMetaData metaData = ps.executeQuery().getMetaData();
//        metaData.getColumnName(1);
//        metaData.getColumnTypeName(1);
//        metaData.isNullable(1);

        StringBuffer buffer = new StringBuffer("| 字段 | 类型 | 必需 | 描述 |\n");
        buffer.append("| :--- | :--- | :--- | :--- |\n");

        while (rs.next()) {
            String fieldName = rs.getString("COLUMN_NAME");

            if ("id".equals(fieldName) || "baseInfoId".equals(fieldName) || "createDate".equals(fieldName) || "lastUpdateDate".equals(fieldName)) {
                continue;
            }

            String colType = rs.getString("TYPE_NAME");
            String msg = rs.getString("REMARKS").trim();
            int nullFlag = rs.getInt("NULLABLE");

            colType = colType.split(" ")[0];
            String fieldType = getObjName(TypeMappingEnum.getJavaType(colType).getJavaValue());
            buffer.append("| " + fieldName + " | " + fieldType + " | " + (nullFlag == 0 ? "是" : "否") + " | " + msg + " | ");
            buffer.append("\n");
        }
        buffer.append("\n\n");
        bos.write(buffer.toString().getBytes());
        bos.flush();

        long endTime = System.currentTimeMillis();
        long spendTime = endTime - startTime;
        System.out.println("总花费时间：" + String.valueOf(spendTime));
    }

    private String getObjName(String beanName) {
        String objName = String.valueOf(beanName.charAt(0)).toLowerCase() + beanName.substring(1);
        return objName;
    }
}
