package com.pb.galaiko.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String name;

    public Skirt(Size size, String color, double prise, String name) {
        super(size, color, prise);
        this.name = name;
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская одежда  : ");
        System.out.println(name + ". " +  "Цвет : " + getColor() +". " + "Размер : " + getSize() +". " +
                " Цена : " + getPrise());

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//(юбка) реализует интерфейс WomenClothes,
