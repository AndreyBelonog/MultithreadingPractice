package com.company;

public class MultithreadingPractice {
    private int mainCounter;


    public static void main(String[] args) {
        // hey
	    MultithreadingPractice mp = new MultithreadingPractice();
	    mp.doWork();
    }

    public synchronized void increment(){
        mainCounter++;
    }

    public void doWork(){
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
           for(int i = 0; i < 10000; i++){
               increment();
           }
        });

        thread1.start();
        thread2.start();

        try{
            thread1.join();
            thread2.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(mainCounter);
    }
}
