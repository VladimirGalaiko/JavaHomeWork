package com.pb.galaiko.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String chain;
    private String name;

    public Dog(String food, String location, String name, String chain) {
        super(food, location);
        this.name = name;
        this.chain = chain;

    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void makeNoise() {
        super.makeNoise();
        System.out.println("Єто " + name + "-" + "шумит");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Єто " + name + "-" + "ест");
    }

    @Override
    public String toString() {
        return "Собака, " +
                "имя: " + name + " " + "Отличительная черта " +
                "-  " + chain + " Любимая еда: " + getFood() + ". " + "Локация: " + getLocation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(chain, dog.chain) && Objects.equals(name, dog.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chain, name);
    }
}


