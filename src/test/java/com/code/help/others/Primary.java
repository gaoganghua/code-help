package com.code.help.others;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Primary {
    enum PrintCase{
        LOWWER("lowwer"), UPPER("upper");
        private String val;

        PrintCase(String val) {
            this.val = val;
        }
    }
    EnumFactory print() default EnumFactory.DOG;

    String val();

    String msg() default "sss";

}
