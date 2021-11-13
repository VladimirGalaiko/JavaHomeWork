package com.pb.galaiko.hw6;

import java.util.Objects;

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
        System.out.println("Какое-то животное шумит");
    }

    public void eat() {
        System.out.println("Какое-то животное ест");

    }

    public void sleep() {
        System.out.println("Какое-то животное спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(food, animal.food) && Objects.equals(location, animal.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(food, location);
    }
}

