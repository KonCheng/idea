package com.koncheng.future;

import com.koncheng.loader.MyClassLoader;

import java.util.concurrent.*;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FutureRunner {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<MyClassLoader> result = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(10);
            return new MyClassLoader("!!");
        });

        IntStream.range(0, 10).forEach(i -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println(result.isDone());
        });
        try {
            MyClassLoader myClassLoader = result.get();
            System.out.println(myClassLoader);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
