package com.code.help.akka_test;

import java.io.Serializable;

public class Msg implements Serializable {
    String message;

    public Msg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
