package com.code.help.others;

import org.junit.Test;

class Dog {
    @Primary(val = "aaa", print = EnumFactory.FISH)
    String id;

    String name;

}

public class AnnoTest {
    @Test
    public void test() throws NoSuchFieldException {
        Primary p = Dog.class.getDeclaredField("id").getAnnotation(Primary.class);
        System.out.println(p.msg());
        p.print().apper();

//        EnumFactory.DOG.apper();
//        EnumFactory.FISH.apper();
    }
}
