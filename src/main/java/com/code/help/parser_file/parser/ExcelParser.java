package com.code.help.parser_file.parser;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ExcelParser implements Parser {
    @Override
    public String getTag() {
        return "excel";
    }

    @Override
    public void parser(File file) {
        System.out.println("excel parse...");
    }

}
