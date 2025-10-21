package com.example;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        int number = rand.nextInt(1500);
        Thread.sleep(number);
        
        return number;
    }

}
