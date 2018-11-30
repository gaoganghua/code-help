package com.code.help.table_to_bean.main;

import com.code.help.table_to_bean.bean.BeanDefine;
import com.code.help.table_to_bean.bean.TableMapping;
import com.code.help.table_to_bean.enums.TypeMappingEnum;
import com.code.help.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class GenerateCode {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TableMapping tableMapping;

    private final String DEFAULT_DIR = "/Users/chancelee/Desktop";

    private final String queryName = "queryByBaseInfoId";

    public void generate() throws SQLException, IOException, ClassNotFoundException {
        File dirFile = FileUtils.getFileByNameNew(tableMapping.getTargetDir(), DEFAULT_DIR);
        String daoPackage = tableMapping.getDaoPackage();
        String beanPackage = tableMapping.getBeanPackage();

        for (BeanDefine beanDefine : tableMapping.getBeanDefines()) {
//            File currentFile = FileUtils.getFileByDirAndName(dirFile, beanDefine.getBeanName() + ".java");
            generateBean(dataSource.getConnection(), beanDefine, dirFile, daoPackage, beanPackage);
//            Map<String, String> maps = generateBean(dataSource.getConnection(), beanDefine, currentFile);
//            generateMapper(currentFile, beanDefine, daoPackage);
        }
    }
    public Map<String, String> generateBean(Connection conn, BeanDefine beanDefine, File dirFile, String daoPackage, String beanPackage) throws IOException, SQLException {
        long startTime = System.currentTimeMillis();

        File currentFile = FileUtils.getFileByDirAndName(dirFile, beanDefine.getBeanName() + ".java");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(currentFile));

        DatabaseMetaData databaseMetaData = conn.getMetaData();
        ResultSet rs = databaseMetaData.getColumns(null, "%", beanDefine.getTabName(), "%");

        Map<String, String> map = new HashMap<>();
        String fieldType = null;
        StringBuilder stringBuilder = new StringBuilder("public class " + beanDefine.getBeanName() + "{\n");
        StringBuilder importBuilder = new StringBuilder();

        StringBuilder mapperBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        mapperBuilder.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        mapperBuilder.append("<mapper namespace=\""+daoPackage+"."+beanDefine.getBeanName()+"Dao\">\n\n");
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();

        StringBuilder sbdao = new StringBuilder();

        String objName = null;
        if(beanDefine.getGenerateDao()){
            sbdao.append("\nimport "+beanPackage+"."+beanDefine.getBeanName()+";\n\n");
            sbdao.append("public interface " + beanDefine.getBeanName() + "Dao{\n\n");
            objName = getObjName(beanDefine.getBeanName());
        }

        sb1.append("\t<sql id=\"fields\">\n\t\t");
        if(beanDefine.getInsert()){
            sb2.append("\t<insert id=\"insert\" parameterType=\""+beanPackage+"."+beanDefine.getBeanName()+"\">\n");
            sb2.append("\t\t<selectKey keyProperty=\"id\" order=\"AFTER\" resultType=\"java.lang.Long\">\n");
            sb2.append("\t\t\tSELECT LAST_INSERT_ID()\n");
            sb2.append("\t\t</selectKey>\n");
            sb2.append("\t\tINSERT INTO "+beanDefine.getTabName()+"\n");
            sb2.append("\t\t(<include refid=\"fields\"/>)\n");
            sb2.append("\t\tvalues\n");
            sb2.append("\t\t(null, ");
            sbdao.append("\tvoid insert("+beanDefine.getBeanName()+" "+objName+");\n\n");
        }
        if(beanDefine.getUpdate()){
            sb3.append("\t<update id=\"update\" parameterType=\""+beanPackage+"."+beanDefine.getBeanName()+"\">\n");
            sb3.append("\t\tupdate "+beanDefine.getTabName()+" set\n");
            sbdao.append("\tvoid update("+beanDefine.getBeanName()+" "+objName+");\n\n");
        }
        if(beanDefine.getQuery()){
            sb4.append("\t<select id=\"queryByBaseInfoId\" parameterType=\"long\" resultType=\""+beanPackage+"."+beanDefine.getBeanName()+"\">\n");
            sb4.append("\t\tSELECT\n");
            sb4.append("\t\t<include refid=\"fields\"/>\n");
            sb4.append("\t\tFROM "+beanDefine.getTabName()+"\n");
            sb4.append("\t\tWHERE baseInfoId = #{baseInfoId}\n");
            sb4.append("\t</select>\n");
            sbdao.append("\t"+beanDefine.getBeanName()+" queryByBaseInfoId(Long baseInfoId);\n\n");
        }
        if(beanDefine.getInsertRecords()){
            sb5.append("\t<insert id=\"insertRecords\" parameterType=\""+beanPackage+"."+beanDefine.getBeanName()+"\">\n");
            sb5.append("\t\tinsert into "+beanDefine.getTabName()+"\n");
            sb5.append("\t\t(<include refid=\"fields\"/>)\n");
            sb5.append("\t\tvalues\n");
            sb5.append("\t\t<foreach item=\"item\" index=\"index\" collection=\"list\" open=\"(\" separator=\"), (\" close=\")\">\n");
            sb5.append("\t\t\tnull, ");
            sbdao.insert(0, "import java.util.List;\n\n");
            sbdao.append("\tvoid insertRecords(List<"+beanDefine.getBeanName()+"> "+objName+"s);\n\n");
        }

        if(beanDefine.getGenerateDao()){
            sbdao.append("}");
        }

        while (rs.next()) {
            String fieldName = rs.getString("COLUMN_NAME");
            String colType = rs.getString("TYPE_NAME");
            colType = colType.split(" ")[0];
            fieldType = TypeMappingEnum.getJavaType(colType).getJavaValue();
            String msg = rs.getString("REMARKS").trim();
            importPackage(fieldType, importBuilder);

            stringBuilder.append("\t/**\n\t *" + msg + "\n\t */\n");
            stringBuilder.append("\tprivate " + fieldType + " " + fieldName + ";\n");

            //mapper
            sb1.append(fieldName + ", ");
            if(beanDefine.getInsert()) {
                if(!fieldName.equals("id") && !fieldName.equals("createDate") && !fieldName.equals("lastUpdateDate")) {
                    sb2.append("#{" + fieldName + "}, ");
                }
            }
            if(beanDefine.getUpdate()){
                if(!fieldName.equals("id") && !fieldName.equals("createDate") && !fieldName.equals("lastUpdateDate")) {
                    sb3.append("\t\t  "+fieldName+" = #{"+fieldName+", jdbcType="+changeMybatisType(colType)+"},\n");
                }
            }
            if(beanDefine.getInsertRecords()){
                if(!fieldName.equals("id") && !fieldName.equals("createDate") && !fieldName.equals("lastUpdateDate")) {
                    sb5.append("#{item." + fieldName + "}, ");
                }
            }
        }
        //mapper
        sb1.deleteCharAt(sb1.length()-2);
        sb1.append("\n\t</sql>\n");
        mapperBuilder.append(sb1.toString());
        if(beanDefine.getInsert()){
            sb2.append("null ,null )\n");
            sb2.append("\t</insert>\n");
            mapperBuilder.append(sb2.toString()+"\n");
        }
        if(beanDefine.getInsertRecords()){
            sb5.append("null,null\n");
            sb5.append("\t\t</foreach>\n");
            sb5.append("\t</insert>\n");
            mapperBuilder.append(sb5.toString()+"\n");
        }
        if(beanDefine.getUpdate()){
            sb3.deleteCharAt(sb3.length()-2);
            sb3.append("\t\twhere id = #{id,jdbcType=BIGINT}\n");
            sb3.append("\t</update>\n");
            mapperBuilder.append(sb3.toString()+"\n");
        }
        if(beanDefine.getQuery()){
            mapperBuilder.append(sb4.toString()+"\n");
        }

        mapperBuilder.append("\n</mapper>");
        File daoFile = FileUtils.getFileByDirAndName(dirFile, beanDefine.getBeanName()+"Dao.java");
        BufferedOutputStream daobos = new BufferedOutputStream(new FileOutputStream(daoFile));

        daobos.write(sbdao.toString().getBytes());
        daobos.flush();
        daobos.close();


        File mappFile = FileUtils.getFileByDirAndName(dirFile, beanDefine.getBeanName()+"Mapper.xml");
        BufferedOutputStream mapbos = new BufferedOutputStream(new FileOutputStream(mappFile));

        mapbos.write(mapperBuilder.toString().getBytes());
        mapbos.flush();
        mapbos.close();

        stringBuilder.append("}");
        if(!StringUtils.isEmpty(importBuilder)){
            importBuilder.append("\n");
            stringBuilder.insert(0, importBuilder);
        }
        bos.write(stringBuilder.toString().getBytes());
        bos.flush();

        long endTime = System.currentTimeMillis();
        long spendTime = endTime - startTime;
        System.out.println("总花费时间：" + String.valueOf(spendTime));

        bos.close();
        return map;
    }

    public void generateMapper(File javafile, BeanDefine beanDefine, String daoPackage) throws ClassNotFoundException {
        Class cls = this.getClass().getClassLoader().loadClass(javafile.getAbsolutePath());

        for(Field field:cls.getDeclaredFields()){
            System.out.println(field.getName());
        }
        StringBuilder mapperBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        mapperBuilder.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        mapperBuilder.append("<mapper namespace=\""+daoPackage+beanDefine+"Dao\">");
    }

    private void importPackage(String fieldType, StringBuilder stringBuilder) {
        if ("Date".equals(fieldType)) {
            if(stringBuilder.indexOf("java.util.Date")==-1) {
                stringBuilder.append("import java.util.Date;\n");
            }
        }
        if ("BigDecimal".equals(fieldType)) {
            if(stringBuilder.indexOf("java.math.BigDecimal")==-1) {
                stringBuilder.append("import java.math.BigDecimal;\n");
            }
        }
    }

    private String changeMybatisType(String colType){
        String mybatisType = null;

        mybatisType = colType;
        if("INT".equals(colType)){
            mybatisType = "INTEGER";
        }
        if("DATETIME".equals(colType)){
            mybatisType = "TIMESTAMP";
        }
        if("TEXT".equals(colType)){
            mybatisType = "VARCHAR";
        }
        return mybatisType;
    }
    private String getObjName(String beanName){
        String objName = String.valueOf(beanName.charAt(0)).toLowerCase()+beanName.substring(1);
        return objName;
    }
}
