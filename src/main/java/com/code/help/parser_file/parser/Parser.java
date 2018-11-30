package com.code.help.parser_file.parser;

import java.io.File;

public interface Parser {
    String getTag();

    void parser(File file);
}
