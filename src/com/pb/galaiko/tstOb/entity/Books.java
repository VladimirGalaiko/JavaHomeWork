package com.pb.galaiko.tstOb.entity;

public class Books {
    private String name;
    private String num;

    public Books(String name,String num) {
        super();
        this.name = name;
        this.num = num;
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
    public String showBook() {
        return "  name:" + name + "  номер телефона:" + num;
    }

}
