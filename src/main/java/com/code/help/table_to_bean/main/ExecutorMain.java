package com.code.help.table_to_bean.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class ExecutorMain {
    @Autowired
    private GenerateCode generateCode;
    @Autowired
    private GenerateMapping mapping;

    //需要一个非参的方法
    @PostConstruct
    public void main() throws ClassNotFoundException, SQLException, IOException {

        generateCode.generate();//生成相关文件
//        mapping.generate();生成映射文档
    }

}