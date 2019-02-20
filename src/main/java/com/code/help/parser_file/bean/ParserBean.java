package com.code.help.parser_file.bean;

import com.code.help.parser_file.enums.ParserTypeEnums;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "parserbean")
@PropertySource(value = {"parsefile/application-parse.yml"})
public class ParserBean {
    private ParserTypeEnums type;

    private String filePath;

    public ParserTypeEnums getType() {
        return type;
    }

    public void setType(String type) {
        this.type = ParserTypeEnums.parse(type);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "ParserBean{" +
                "type=" + type +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
