package com.code.help.parser_file.main;

import com.code.help.parser_file.bean.ParserBean;
import com.code.help.parser_file.parser.Parser;
import com.code.help.util.ClassUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ExectorMain {
    @Autowired
    private ParserBean bean;

    private final String PACKAGE = "com.code.help.parser_file.parser";

    //@PostConstruct
    public void start() throws Exception {
        parseFile();
    }

    public void parseFile() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Parser parser = (Parser) ClassUtils.getObject(PACKAGE+"."+bean.getType().getValue());
        System.out.println(parser.getClass());
//        parser.parser();
    }
}
