package com.pb.galaiko.hw11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;


public  class Main  {

     List<Person> persons = new ArrayList();

     Scanner scanner = new Scanner(System.in);
     boolean status = true;

     private String tname;
     private String tnum;
     private String tdateOfBirth;
     private String tadres;
     LocalDateTime lastEdited;


    public static void main(String[] args) throws Exception {

        Main   phone =new Main();
        phone.loadALL();
        System.out.println("Телефонная книга загружена...");
        phone.operator();
    }

      public void operator()   {

        while (status) {
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("  1. Новый   2. Удалить   3. Обновить   4. Сорт. по имени   5. Сорт. по номеру  6. Сохранить" +
                    " 7. Вывести телефонную книгу 0. Выход");
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("Пожалуйста, введите номер, чтобы выбрать соответствующую функцию:");
            String selected = scanner.next();
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
                    sortName();
                case "5":
                    sortName();
                    break;
                case "6":
                    saveBook();
                    break;
                case "7":
                    loadALL();
                    break;
                case "0":
                    scanner.close();
                    status = false;
                    break;
            }
        }
    }

    private void delete()   {
        System.out.println("Пожалуйста, введите имя контакта для удаления:");
        String dname = scanner.next();

        for (int i = 0; i < persons.size(); i++) {
            Person t = persons.get(i);
            if (t.getName().equals(dname)) {
                persons.remove(t);
                System.out.println("Успешно удалено !");
            } else {
                continue;
            }
        }
        saveBook();
    }

    private void sortName() {
        persons.sort(Comparator.comparing(p -> p.getName()));
        saveBook();
          }
    private void sortNum(){
        persons.sort(Comparator.comparing(p -> p.getNum()));
        saveBook();
            }

    public void loadALL() {

        File file = Paths.get("files/phoneBook.txt").toFile();
        if (!file.exists()) {

            System.out.println("Файла не существует.");
            return;
        }
        else {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDateTime.class, new LocalDateSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateDeserializer());
            mapper.registerModule(module);

            try {persons = new ArrayList<>(Arrays.asList(mapper.readValue(file, Person[].class)));
                 persons.forEach(System.out::println);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private  void update() {
        Scanner s = new Scanner(System.in);
        System.out.println("Пожалуйста, введите имя учетной записи для изменения: ");
        String unam = s.nextLine();
        System.out.println("Введите новые номер/номера телефонов ");
        String unum = s.nextLine();

        for (Person i : persons) {
            if (i.getName().equals(unam)) {
                i.setNum(unum);
                i.setTimestamp(LocalDateTime.now());

                saveBook();
                System.out.println("Изменено успешно !");

            }
        }
    }

    private void addBook() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Пожалуйста, введите имя: ");
        tname = scan.nextLine();
        System.out.println("Пожалуйста, введите номер телефона, можно ввести несколько: ");
        tnum = scan.nextLine();
        System.out.println("Пожалуйста, введите дату рождения: ");
        tdateOfBirth = scan.nextLine();
        System.out.println("Пожалуйста, введите адрес: ");
        tadres = scan.nextLine();

        Person bk = new Person(tname,tnum,tdateOfBirth,tadres, LocalDateTime.now());
        persons.add(bk);
        System.out.println(bk);
        saveBook();
        System.out.println("Успешно добавлено !");

    }

    private void saveBook() {
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
