package com.pb.galaiko.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    private String name;

    public Tshirt(Size size, String color, double prise, String name) {
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
//(футболка) реализует интерфейсы
// ManClothes и WomenClothes,