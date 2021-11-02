package com.pb.galaiko.hw5;

public class Reader {


    String fio;
    int numchitbilet;
    String facuklet;
    String birthday;
    String telefon;
    int kolknig;


    public Reader(String fio, int numchitbilet, String facultet, String birthday, String telefon) {
        this.fio = fio;
        this.numchitbilet = numchitbilet;
        this.facuklet = facultet;
        this.birthday = birthday;
        this.telefon = telefon;
    }


    public void takeBook(int kolknig) {
        System.out.println(fio + "." + " Взял книги, колличество : " + kolknig);
    }

    public void takeBook(Book... takedBooks) {
        System.out.println(fio + "." + " Взял книги : " + takedBooks[0].name +
                ", " + takedBooks[1].name + ", " + takedBooks[2].name);

        System.out.println(fio + "." + " Взял книги : ");
        for (int i = 0; i < 3; i++) {
            System.out.println(takedBooks[i].name + "(" + takedBooks[i].avtor + ", "
                    + takedBooks[i].god + ").");
        }
    }

    public void returnBook(int kolknig) {
        System.out.println(fio + "." + " Вернул книги, колличество : " + kolknig);
    }

    public void returnBook(Book... returnBook) {
        System.out.println(fio + "." + " Вернул книги : " + returnBook[0].name +
                ", " + returnBook[1].name + ", " + returnBook[2].name + ".");

        System.out.println(fio + "." + " Вернул книги : ");
        for (int i = 0; i < 3; i++) {
            System.out.println(returnBook[i].name + "(" + returnBook[i].avtor +
                    ", " + returnBook[i].god + ").");
        }

    }


    public String getPosetiteli() {
        return "" +
                "ФИО: " + fio +
                ". Номер читательского билета: " + numchitbilet +
                ". Факультет: " + facuklet +
                ". Дата рождения: " + birthday + ". Телефон "
                + telefon + "";
    }

}

