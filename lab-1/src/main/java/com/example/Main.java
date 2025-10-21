package com.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        System.out.println("Rozpoczęcie programu");
        TestRunnable tr1 = new TestRunnable();
        Thread th1 = new Thread(tr1);
        th1.start();
        System.out.println("Zakończenie programu");

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        
        // th2.start();
        ExecutorService executorService = 
                        Executors.newFixedThreadPool(5);

        Future<Integer> result = executorService.submit(new TestCallable());

        try {
            System.out.println("Wylosowana  wartość z wątka: " + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // for (int n = 0; n<20; n++){
        //     executorService.submit(new TestRunnable());
        // }

        // executorService.shutdown();

    }
}