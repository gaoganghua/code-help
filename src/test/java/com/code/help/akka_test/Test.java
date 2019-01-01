package com.code.help.akka_test;

import akka.actor.*;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
//        test1();
        test2();
//        test3();
    }
    public void test3() throws IllegalAccessException, InstantiationException {
//        ActorRefFactory factory = new ActorCell();
//        System.out.println(factory==null);
    }
    public void test2() throws Exception {
        ActorSystem system = ActorSystem.create("rootName");

        ActorRef greeter1 = system.actorOf(Props.create(Greeter.class), "greeter1");
        ActorRef per1 = system.actorOf(Props.create(Person.class), "per1");

        Future future = Patterns.ask(greeter1, "ask", Timeout.longToTimeout(2000));
//        Object o = Await.result(future, Duration.apply(3, TimeUnit.SECONDS));
//        System.out.println("返回消息："+o);
//        System.out.println(per.path().);

//        Future<Object> future1 = Patterns.ask(greeter1, 8, 1000);
//        //akka重定向
//        Patterns.pipe(future1, system.dispatcher()).to(per1);

//        greeter1.tell(PoisonPill.getInstance(), ActorRef.noSender());

    }
    public void test1(){
        ActorSystem system = ActorSystem.create("rootName");

        ActorRef greeter1 = system.actorOf(Props.create(Greeter.class), "greeter1");
        ActorRef per1 = system.actorOf(Props.create(Person.class), "per1");

        greeter1.tell(new Msg("hello, greet"), per1);
//        System.out.println(per.path().);

    }
}
