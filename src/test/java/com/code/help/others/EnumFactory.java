package com.code.help.others;

public enum EnumFactory {
    DOG{
        public void apper(){
            System.out.println("dog");
        }
    },

    FISH{
        public void apper(){
            System.out.println("fish");
        }
    };

    public abstract void apper();
}
