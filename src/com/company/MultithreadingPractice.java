package com.company;

public class MultithreadingPractice {
    private int mainCounter;


    public static void main(String[] args) {
        // hey
	    MultithreadingPractice mp = new MultithreadingPractice();
	    mp.doWork();
    }

    public void doWork(){
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                mainCounter++;
            }
        });
        thread.start();

        try{
            thread.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(mainCounter);
    }
}
