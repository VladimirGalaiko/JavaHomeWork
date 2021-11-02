package com.pb.galaiko.hw5;

import java.util.ArrayList;


public class Library {


    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("Приключения", "Иванов И.И.", "2000г.");
        books[1] = new Book("Словарь", "Сидоров А.В.", "1987г.");
        books[2] = new Book("Энциклопедия ", "Гусев К.В.", "1991г.");


        System.out.println("Книги в библиотеке: ");
        for (Book booki : books) {
            System.out.println(booki.getKnigi());
        }

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Петров В.В", 52, "Экономический", "01.03.1983", "0675552131");
        readers[1] = new Reader("Бунин В.О", 20, "Исторический", "31.07.1990", "0632316540");
        readers[2] = new Reader("Гнездов А.А", 33, "Гуманитарный", "05.06.2000", "0563419988");

        System.out.println("Посетители : ");
        for (Reader readi : readers) {
            System.out.println(readi.getPosetiteli());
        }
        for (int i = 0; i < 3; i++) {
            readers[i].takeBook(3);
            readers[i].takeBook(books);
            readers[i].returnBook(3);
            readers[i].returnBook(books);
        }

    }
}












