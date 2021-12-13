package com.pb.galaiko.hw11;

import java.time.LocalDateTime;

public class Person  {
    private  String name;
    private String num;
    private String adres;
    private String dateOfBirth;
    private  LocalDateTime lastEdited;


     public Person() {
    }
//
//    public Person(String name, String num,String adres) {
//        this.name = name;
//        this.num = num;
//    }


    public Person(String name,String num,String dateOfBirth,String adres,LocalDateTime lastedited) {
        //super();
        this.name = name;
        this.num = num;
        this.dateOfBirth = dateOfBirth;
        this.adres =adres;
        this.lastEdited = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return lastEdited ;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.lastEdited = timestamp;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getNum() {
        return num;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", adres='" + adres + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", lastedited=" + lastEdited +
                '}';
    }
}

