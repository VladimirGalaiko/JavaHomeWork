package com.pb.galaiko.hw6;


public class Veterinarian {


    public void treatAnimal(Animal animal) {

        System.out.println("Животное из локации (" + animal.getLocation() + ")," +
                " " + "которое любит  " + animal.getFood() + ", " + "отправлено к доктору лечится");
    }
}


