package com.scytalys;

import java.util.ArrayList;
import java.util.List;


// ----------------------- CONCURRENT SOLUTION WITH THREADS

public class MainWithThreads {
    public static void main(String[] args) {

        List<Maker> makers= new ArrayList<>();
        makers.add(new Maker(1, "Vrazw to avgo"));
        makers.add(new Maker(2, "Vazw to augo sto piato"));
        makers.add(new Maker(3, "Vrazw to gala"));
        makers.add(new Maker(4, "Vazw to gala stin koupa"));
        makers.add(new Maker(5, "Etoimazw to trapezi"));

        ArrayList<Thread> threads = new ArrayList<>();

       long startingTime = System.currentTimeMillis();
       for (Maker maker: makers){
           Thread thread = new Thread(maker);
           threads.add(thread);
           thread.start();
       }
        // prepei to join na einai meta to start twn threads diaforetika tha itan sequential
       for (Thread thread: threads){
        try {
            thread.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        }

        long endingTime = System.currentTimeMillis();
        System.out.println("time: " + (endingTime-startingTime) + " millisecond");

    }
}