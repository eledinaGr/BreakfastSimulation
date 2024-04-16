package com.scytalys.service;

import com.scytalys.model.Breakfast;

import java.util.concurrent.Callable;

public class WorkerCallable implements Callable<Breakfast>{
    private int id;
    private String nameofTask;

    public WorkerCallable(int id, String nameofTask) {
        this.id = id;
        this.nameofTask = nameofTask;
    }

    @Override
    public  Breakfast call() throws Exception {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Breakfast(id, nameofTask);
    }

}
