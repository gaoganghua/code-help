package com.code.help.goodcode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    //stream和lamble
    public void testStream() {
        Predicate<Integer> predicate = (i) -> {
            return i > 3 ? true : false;
        };
        List<Integer> all = Arrays.asList(new Integer[]{3, 5, 6, 7, 3, 4, 9, 1, 0});
        List<String> str = all.parallelStream()//并行处理
                .filter(predicate)
                .map((i) -> String.format("%s price: %.2f", i * 2))
                .sorted((p, p2) -> (p.compareTo(p2)))
                .collect(Collectors.toList());
//                .forEach((i)->{
//                    System.out.println(i);
//                });
    }
    public void test(){
        //基本的stream流，不使用并行计算(因为并行计算受内核的处理器数量的限制，如果只有8个处理器，只能同时处理8个任务)
//        List<String> str = shops.stream()
//                .map(shop->shop.getPrice("hhhhh")) //获取 one:120.10:GOLDD 格式字符串
//                .map(Quote::parse) //转换为 Quote 对象
//                .map(Discount::applyDiscount) //返回 Quote的shop中的折扣价格
//                .collect(toList());
//        System.out.print(str);
        //使用CompletableFuture改造后的，executors会根据线程池的数据自动调度任务
//        List<CompletableFuture<String>> priceFutures = shops.stream()
//                //异步获取每个shop中的价格
//                .map(shop -> CompletableFuture.supplyAsync(
//                        () -> shop.getPrice("hhhhh", executor)
//                ))
//                //Quote对象存在时，对其返回值进行转换
//                .map(future -> future.thenApply(Quote::parse))
//                //使用另一个异步任务构造期望的future，申请折扣
//                .map(future -> future.thenCompose(quote ->
//                        CompletableFuture.supplyAsync(
//                                () -> Discount.applyDiscount(quote), executor)
//                ))
//                .collect(toList());
//        //等待流中的所有Future执行完毕，提取各自的返回值
//        List<String> str = priceFutures.stream().map(CompletableFuture::join).collect(toList());
//        System.out.print(str);
    }

}
