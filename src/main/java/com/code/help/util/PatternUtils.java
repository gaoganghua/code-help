package com.code.help.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternUtils {
    private final static String REPLACE_REGEX = "${value}";

    public static boolean match(String original, String reg){
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(original);
        return matcher.matches();
    }

    public static boolean isReplace(String original){
        return match(original, REPLACE_REGEX);
    }
}
