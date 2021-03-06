package com.pb.galaiko.hw7;


public class Atelier {

    public static void main(String[] args) {

        Size[] razmer = Size.values();
        System.out.println("Размеры одежды: ");
        for (Size razm : razmer) {
            System.out.print(razm + " - ");
            System.out.print(razm.getDescription() + " - ");
            System.out.println(razm.getEuroSize());
        }

        Clothes tie = new Tie(Size.XS, "черный", 63.35, "Галстук");
        Clothes skirt = new Skirt(Size.S, "зеленая", 208.99, "Юбка");
        Clothes pants = new Pants(Size.XS, "желтые", 250.99, "Штаны");
        Clothes tshirt = new Tshirt(Size.XXS, "желтая", 105.35, "Футболка");

        Clothes[] clothes = {tie, skirt, pants, tshirt};
        dressMan(clothes);
        dressWomen(clothes);

    }

    public static void dressMan(Clothes[] clothes) {
        for (Clothes i : clothes) {
            if (i instanceof ManClothes){
                ((ManClothes) i).dressMan();
            }
        }
    }

    public static void dressWomen(Clothes[] clothes) {
        for (Clothes i : clothes) {
            if (i instanceof WomenClothes){
                ((WomenClothes) i).dressWomen();
            }
        }
    }
}

// Создать класс Atelier с методом main, и еще двумя статическими методами:
//   на вход которых будет поступать массив, содержащий все типы одежды.

