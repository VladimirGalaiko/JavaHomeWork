package com.pb.galaiko.hw6;

public class Horse extends Animal {
    private String name;
    private String griva;

    public Horse(String food, String location, String name, String griva) {
        super(food, location);
        this.name = name;
        this.griva = griva;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGriva() {
        return griva;
    }

    public void setGriva(String griva) {
        this.griva = griva;
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
