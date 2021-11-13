package com.pb.galaiko.hw7;

public abstract class Clothes {
    private double prise;
    private String color;
    private Size size;

    public Clothes(Size size, String color, double prise) {
        this.size = size;
        this.color = color;
        this.prise = prise;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(float prise) {
        this.prise = prise;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }



    @Override
    public String toString() {
        return "Clothes{" +
                "prise=" + prise +
                ", color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
//содержащий переменные
// размер (типа Size), стоимость, цвет.