package com.pb.galaiko.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {
    private String name;

    public Pants(Size size, String color, double prise, String name) {
        super(size, color, prise);
        this.name = name;
    }

    @Override
    public void dressMan() {
        System.out.println(name + ". " +  "Цвет : " + getColor() +". " + "Размер : " + getSize() +". " +
                " Цена : " + getPrise());

    }

    @Override
    public void dressWomen() {
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
//(штаны) реализует интерфейсы
// ManClothes и WomenClothes,