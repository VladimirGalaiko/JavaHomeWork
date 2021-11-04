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

    @Override
    public String toString() {
        return "Кошка, " +
                "имя: " + name + " " + "Отличительная черта " +
                "- одет  " + collar + " Любимая еда: " + getFood() + ". " + "Локация: " + getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name) && Objects.equals(collar, cat.collar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, collar);
    }
}
