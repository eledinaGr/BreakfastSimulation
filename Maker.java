package com.scytalys;

public class Maker implements Runnable{

    private int id;
    private String nameOftask;

    public Maker(int id, String nameOftask) {
        this.id = id;
        this.nameOftask = nameOftask;
    }

    public void doWork(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void run() {
        System.out.println("Task " + id + " started: " + nameOftask);
        doWork();
        System.out.println("Thread " + id + " " + nameOftask + " has finished working. ");
    }
}
