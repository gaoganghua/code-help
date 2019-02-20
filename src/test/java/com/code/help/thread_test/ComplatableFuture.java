package com.code.help.thread_test;

import org.assertj.core.util.Preconditions;
import org.junit.Test;
import scala.util.parsing.combinator.testing.Str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComplatableFuture {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        }).thenApply((i) -> {
            return i * 2;
        });

        System.out.println(completableFuture.get());
        System.out.println("hello");

//        Preconditions.checkNotNull()
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        List<String> all = Arrays.asList(new String[]{"a", "r", "c", "d"});

        List<CompletableFuture<String>> futures = new ArrayList<>();
        futures = all.stream().map((s) -> {
            return CompletableFuture.supplyAsync(() -> {
                return s + "-" + s;
            }).thenApply((i) -> {
                return i + "..";
            });
        }).collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((r, e)->{
            System.out.println(r);
            System.out.println(e);
            System.out.println("finish...");
        }).join();
        for (CompletableFuture future : futures) {
            System.out.println(future.get());
        }
        System.out.println("hello");
    }
    public void testt(){
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
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CyclicBarrier cb = new CyclicBarrier(2, () -> {
            System.out.println("finish..");
        });

        es.submit(()->{
            System.out.println("task1...");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        es.submit(()->{
            System.out.println("task2...");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        System.out.println("hello");
    }
    @Test
    public void test4() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        CountDownLatch count = new CountDownLatch(2);
        es.submit(()->{
            System.out.println("task1..");
            count.countDown();
        });
        es.submit(()->{
            System.out.println("task2..");
            count.countDown();
        });
        es.submit(()->{
            try {
                count.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("finish..");
        });

        System.out.println("hello");
    }
    @Test
    public void test5() throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Semaphore sem = new Semaphore(2);
        CountDownLatch count = new CountDownLatch(10);

        for(int i=0;i<10;i++){
            final Integer a = i;
            es.submit(()->{
                try {
                    sem.acquire();
                    System.out.println(a+"..add");
                    TimeUnit.SECONDS.sleep(2);
                    sem.release();
                    System.out.println(a+"..del");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count.countDown();
                }
            });
        }

        count.await();
        System.out.println("hello");
    }
    @Test
    public void test6(){
        System.out.print(Runtime.getRuntime().availableProcessors());
    }
}
