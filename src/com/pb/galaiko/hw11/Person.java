package com.pb.galaiko.hw11;

import java.io.Serializable;
import java.time.Instant;

public class Person implements Serializable {
    private final static long serialVersionUID = 42;

    private String name;
    private String num;
    private Instant timestamp;



    public Person(String name,String num,Instant timestamp) {
        //super();
        this.name = name;
        this.num = num;
        this.timestamp = timestamp ;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
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
                ", timestamp=" + timestamp +
                '}';
    }



//    public String toPerson() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", phone='" + num + '\'' +
//                '}';
    }

