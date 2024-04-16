package com.scytalys;

import java.util.ArrayList;
import java.util.List;

// -------------------------------  SEQUENTIAL SOLUTION
public class Main {
    public static void main(String[] args) {

        List<Maker> makers= new ArrayList<>();
        makers.add(new Maker(1, "Vrazw to avgo"));
        makers.add(new Maker(2, "Vazw to augo sto piato"));
        makers.add(new Maker(3, "Vrazw to gala"));
        makers.add(new Maker(4, "Vazw to gala stin koupa"));
        makers.add(new Maker(5, "Etoimazw to trapezi"));


        long startingTime = System.currentTimeMillis();

        for(Maker maker:makers){
            maker.run();
        }

        long endingTime = System.currentTimeMillis();
        System.out.println("time: " + (endingTime-startingTime) + " millisecond");

    }
}