package com.code.help.akka_test;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {
    @Override
    public void onReceive(Object o) throws Exception {
        if(o instanceof Msg){
            System.out.println("使用tell模式，收到消息:"+((Msg) o).getMessage());
            getSender().tell(new Msg("Greeter已收到"), getSelf());
        }else if(o!=null){
            System.out.println("使用ask模式，收到消息:"+o.toString());
            getSender().tell(o, getSelf());
        }else{
            unhandled(o);
        }
    }
}
