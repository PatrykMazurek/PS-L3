package com.example;

public class TestRunnable implements Runnable{
    
    @Override
    public void run(){
        System.out.println("wątek: " + Thread.currentThread().getName());
        for (int i = 0; i<5; i++){
            System.out.println("numer: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("zakończenie pracy");
    }

}
