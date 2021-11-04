package com.pb.galaiko.hw6;

import java.util.Objects;

public class Cat extends Animal {
    private String name;
    private String collar;


    public Cat(String food, String location, String name, String collar) {
        super(food, location);
        this.name = name;
        this.collar = collar;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollar() {
        return collar;
    }

    public void setCollar(String collar) {
        this.collar = collar;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Єто " + name + " - " + "шумит");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Єто " + name + " - " + "ест");
    }
}
