package com.pb.galaiko.hw11;

import java.time.LocalDateTime;

public class Person  {
  // private final static long serialVersionUID = 42;

    private String name;
    private String num;
    private  LocalDateTime timestamp; //transient



     public Person() {

    }

    public Person(String name, String num) {
        this.name = name;
        this.num = num;
    }


    public Person(String name,String num,LocalDateTime timestamp) {
        //super();
        this.name = name;
        this.num = num;
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp ;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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
}

