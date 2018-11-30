package com.code.help.akka_test;

import akka.actor.UntypedActor;

public class Person extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof Msg){
            System.out.println("收到来自Greenter:"+((Msg) o).getMessage());
        }else if(o instanceof Integer || o instanceof String){
            System.out.println("使用ask模式,消息："+o);
        }else{
            unhandled(o);
        }
    }
}
