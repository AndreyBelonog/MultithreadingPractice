package com.company;

public class MultithreadingPractice {
    private int ourCounter;


    public static void main(String[] args) {
        // hey
	    MultithreadingPractice mp = new MultithreadingPractice();
	    mp.doWork();
    }

    public void doWork(){
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++){
                ourCounter++;
            }
        });
        thread1.start();

        try{
            thread1.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(ourCounter);
    }
}
