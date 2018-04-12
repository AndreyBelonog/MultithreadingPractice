package com.company;

public class MultithreadingPractice {
    private int counter;

    public static void main(String[] args) {
	    MultithreadingPractice mp = new MultithreadingPractice();
	    mp.doJob();
    }

    public void doJob(){
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                counter++;
            }
        });
        thread1.start();

        try{
            thread1.join();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }

        System.out.println(counter);
    }
}
