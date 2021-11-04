package com.pb.galaiko.hw6;

public class Animal {

    private String food;
    private String location;

    public Animal(String food, String location) {

        this.food = food;
        this.location = location;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("Такое-то животное шумит");
    }

    public void eat() {
        System.out.println("Такое-то животное ест");

    }

    public void sleep() {
        System.out.println("Такое-то животное спит");
    }

}

