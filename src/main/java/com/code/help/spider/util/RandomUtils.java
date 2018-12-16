package com.code.help.spider.util;

import java.util.Random;

public class RandomUtils {
    public static Integer[] generateRandom(int num, Integer max) {
        if (num < 0) {
            return null;
        }
        Integer[] vals = new Integer[num];

        Random random = new Random();
        for (int i = 0; i < num; i++) {
            vals[i] = random.nextInt(max);
        }
        return vals;
    }
    public static Integer getRandom(Integer max) {
        Random random = new Random();
        return random.nextInt(max);
    }

}
