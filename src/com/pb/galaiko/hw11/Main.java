package com.pb.galaiko.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public  class Main  {

    static List<Person> persons = new ArrayList();
    static Scanner sc = new Scanner(System.in);
    static boolean status = true;
    static String tname;
    static String tnum;
    static LocalDateTime  timestamp2;


    public  static void main(String[] args) throws Exception {

        Main phone = new Main();
         operator();
    }


    public static void operator() throws IOException {

        while (status) {
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("  1. Новый   2. Удалить   3. Обновить   4. Запросить все   5. Сохранить  6. Загрузить 0. Выход");
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("Пожалуйста, введите номер, чтобы выбрать соответствующую функцию:");
            String selected = sc.next();
            switch (selected) {
                case "1":
                    addBook();
                    break;
                case "2":
                    delete();
                    break;
                case "3":
                    update();
                    break;
                case "4":
                    findAll();
                    break;
                case "5":
                    saveBook();
                    break;
                case "6":
                    loadALL();
                    break;
                case "0":
                    sc.close();
                    status = false;
                    break;
            }
        }
    }

    private static void update() throws IOException {

        System.out.println("Пожалуйста, введите имя учетной записи для изменения:");
        String unam = sc.next();
        System.out.println("Введите измененный номер:");
        String unum = sc.next();
        for (Person bk : persons) {
            if (bk.getName().equals(unam)) {
                bk.setNum(unum);
                bk.setTimestamp(LocalDateTime.now());
                System.out.println("Изменено успешно !");
            }
        }
    }

    private static void delete() {
        System.out.println("Пожалуйста, введите имя контакта для удаления:");
        String dname = sc.next();
        for (int i = 0; i < persons.size(); i++) {
            Person bk = persons.get(i);
            if (bk.getName().equals(dname)) {
                persons.remove(bk);
                System.out.println("Успешно удалено !");
            } else {
                continue;
            }
        }
    }

    private static void findAll() {
        //System.out.println(persons.get(0).getClass().getName());

        for (Person bk : persons) {
            System.out.println(bk.toString());

        }
    }
    private static void loadALL() {

        File file = Paths.get("files/phoneBook.txt").toFile();//new File("files/phoneBook.txt");
        if (!file.exists()) {

            System.out.println("не сущ.");
            return;
        } else {

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDateTime.class, new LocalDateSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
            mapper.registerModule(module);

            try {

                persons = Arrays.asList(mapper.readValue(file, Person[].class));

                persons.forEach(System.out::println);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void addBook() {

        System.out.println("Пожалуйста, введите имя:");
        tname = sc.next();
        System.out.println("Пожалуйста, введите номер телефона:");
        tnum = sc.next();

        Person bk = new Person(tname,tnum, LocalDateTime.now());
        persons.add(bk);
        System.out.println(bk);
        System.out.println("Успешно добавлено !");
    }

     private static void saveBook() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateSerializer());
        module.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        try {
            mapper.writeValue(Paths.get("files/phoneBook.txt").toFile(), persons);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
