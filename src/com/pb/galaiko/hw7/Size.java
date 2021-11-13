package com.pb.galaiko.hw7;

public enum Size {
    XXS("Детский размер", 32),
    XS("Взрослый размер", 34),
    S("Взрослый размер", 36),
    M("Взрослый размер", 38),
    L("Взрослый размер", 40);

    private String description;
    private int euroSize;

    Size(String description, int euroSize) {
        this.description = description;
        this.euroSize = euroSize;

    }

    public String getDescription() {
        return "" + description + "";

    }
    //возвращающий строку для XXS "Детский размер"
    // , для остальных "Взрослый размер"


    public String getEuroSize() {
        return "" + euroSize + "";

    }
}

//возвращающий числовое значение (32, 34, 36, 38, 40)
// соответствующее каждому размеру.
//Создать конструктор принимающий на вход
// description и euroSize.


