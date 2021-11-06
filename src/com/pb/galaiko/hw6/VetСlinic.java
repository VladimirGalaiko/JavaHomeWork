package com.pb.galaiko.hw6;

import java.lang.reflect.Constructor;

public class VetСlinic {


    public static void main(String[] args) throws Exception {

        Animal[] animal = new Animal[3];
        animal[0] = new Cat("Вискас", "квартира", "Клара.", " синий ошейник.");
        animal[1] = new Dog("кости", "гараж", "Бакс.", "сидит на цепи.");
        animal[2] = new Horse("сено", "хлев", "Буйный.", "красивая грива.");

        System.out.println("Наблюдаемыем животные : ");

        for (int i = 0; i < 3; i++) {
            animal[i].toString();
            System.out.println(animal[i]);
        }

        System.out.println();

        for (int i = 0; i < 3; i++) {
            animal[i].makeNoise();
            animal[i].eat();
        }

        System.out.println();

        Class vetClazz = Class.forName("com.pb.galaiko.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[]{});
        Object obj = constr.newInstance();

        if (obj instanceof Veterinarian) ;
        for (int i = 0; i < 3; i++) {
            ((Veterinarian) obj).treatAnimal(animal[i]);
        }
    }
}

