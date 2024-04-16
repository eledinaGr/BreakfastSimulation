package com.scytalys.model;

public class Breakfast {

    private int id;

    private String name;


    public Breakfast(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Breakfast{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
