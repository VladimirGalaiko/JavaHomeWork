package com.pb.galaiko.hw7;

public class Tie extends Clothes implements ManClothes {

    private String name;

    public Tie(Size size, String color, double prise, String name) {
        super(size, color, prise);
        this.name = name;

    }

    @Override
    public void dressMan() {
        System.out.println("Мужская одежда : ");
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

//(галстук) реализует интерфейс ManClothes.