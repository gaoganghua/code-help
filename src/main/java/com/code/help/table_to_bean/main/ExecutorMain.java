package com.code.help.table_to_bean.main;

import com.code.help.table_to_bean.bean.BeanDefine;
import com.code.help.table_to_bean.bean.TableMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;

@Component
public class ExecutorMain {
    @Autowired
    private GenerateCode generateCode;

    //需要一个非参的方法
    @PostConstruct
    public void main() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("tabletobean start....");
        generateCode.generate();
    }
    /*
    public void test(){
                        if(!field.getName().equals("id") && !field.getName().equals("createDate") && !field.getName().equals("lastUpdateDate")) {
                            sb2.append("#{item." + field.getName() + "},");
                        }

            public void testt() throws SQLException {
                String[] s = {"analy", "base", "auth", "contacts", "overdue", "risk"};
                for(String tab:s){
                    tab = "t_debit_yxb_"+tab+"_info";
                    ResultSet rs = getColumns(getDataSource().getConnection(), tab);

                    System.out.println(tab);
                    StringBuilder sb = new StringBuilder();
                    while(rs.next()){

                        String n = rs.getString("COLUMN_NAME");
                        String t = rs.getString("TYPE_NAME");
                        if(!n.equals("id")&& !n.equals("createDate") && !n.equals("baseInfoId") && !n.equals("lastUpdateDate"))
                            sb.append(n+" = #{"+n+", jdbcType="+t.split(" ")[0]+"},\n");
                    }
                    System.out.println(sb.toString());
                }

            }
            @Test
            public void test() throws SQLException, InterruptedException {
                DataSource dataSource = getDataSource();

                ExecutorService executorService = Executors.newFixedThreadPool(5);

                String[] ss2 = {"YxbAnalyInfo"};
                for(int i=0;i<ss.length;i++) {
                    Connection conn1 = null;
                    String tabName = ss[i];
                    try {
                        ResultSet rs = getColumns(conn1, tabName);

                        StringBuffer sb = new StringBuffer();
                        sb.append("public class "+ss2[i]+"RDM{");
                        sb.append("\n\n");
                        while (rs.next()) {
                            String fieldName = rs.getString("COLUMN_NAME");
                            System.out.println(fieldName);
                            String fieldType = null;
                            String colType = rs.getString("TYPE_NAME");
                            String msg = rs.getString("REMARKS");
                            colType = colType.split(" ")[0];
                            switch (colType) {
                                case "INT":
                                case "INTEGER":
                                    fieldType = "Integer";
                                    break;
                                case "CHAR":
                                case "VARCHAR":
                                case "TEXT":
                                    fieldType = "String";
                                    break;
                                case "BIGINT":
                                    fieldType = "Long";
                                    break;
                                case "DECIMAL":
                                    fieldType = "BigDecimal";
                                    break;
                                case "TIMESTAMP":
                                case "DATETIME":
                                case "DATE":
                                case "TIME":
                                    fieldType = "Date";
                                    break;
                                case "BIT":
                                    fieldType = "Boolean";
                                    break;
                                case "TINYINT":
                                    fieldType = "Byte";
                                    break;
                            }
                            System.out.println(fieldType);*/
//                            sb.append("\t/**\n\t*"+msg+"\n\t*/\n");
//                            sb.append("\tprivate " + fieldType + " " + fieldName + ";\n");
//                        }
//                        sb.append("}");
//                        String mk = null;//this.getClass().getClassLoader().getResource("/").getPath();
//                        System.out.println(mk);
//                        mk = "/Users/chancelee/Desktop/DEFAULT/";
//
//                        File f = new File(mk, ss2[i]+"RDM.java");
//                        if (f.exists()) {
//                            f.delete();
//                        }
//                        f.createNewFile();
//                        FileOutputStream fos = new FileOutputStream(f);
//
//                        fos.write(sb.toString().getBytes());
//                        fos.flush();
//                        fos.close();
//
//                    } catch (SQLException | IOException e) {
//                        e.printStackTrace();
//                    }
//                }
        /*Callable f2 = ()->{
            Connection conn2 = dataSource.getConnection();
            DatabaseMetaData databaseMetaData = conn2.getMetaData();
            ResultSet rs = databaseMetaData.getColumns(null, "%", "t_debit_yxb_auth_info", "%");

            while(rs.next()){
                String fieldName = rs.getString("COLUMN_NAME");
            System.out.println(fieldName);
            }
            cyclicBarrier.await();
            return 1;

            }
            private DataSource getDataSource(){
                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
                dataSourceBuilder.url("jdbc:mysql://192.168.1.114:3306/basisdata_minterm");
                dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
                dataSourceBuilder.username("root");
                dataSourceBuilder.password("0.123abc");
                DataSource dataSource = dataSourceBuilder.build();
                return dataSource;
            }
            private ResultSet getColumns(Connection conn, String tabName) throws SQLException {
                DatabaseMetaData databaseMetaData = conn.getMetaData();
                ResultSet rs = databaseMetaData.getColumns(null, "%", tabName, "%");
                return rs;
            }
        }*/

//    }
}
