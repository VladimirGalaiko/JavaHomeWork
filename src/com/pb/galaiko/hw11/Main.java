package com.pb.galaiko.hw11;


import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Main {
    List <Person> persons = new ArrayList();
    Scanner sc = new Scanner(System.in);
    boolean status = true;
    String tname;
    String tnum;
    Instant timestamp;// = Instant.now();;// Instant timestamp = Instant.now();


    public static void main(String[] args) throws  Exception {
        Main phone = new Main(); // Определение объекта PhoneOperator для телефона
        File file = new File("files/phoneBook.txt"); // Определите файл, путь в скобках
        if (!file.exists()) {
            // Если файл не существует, создайте новый файл
            file.createNewFile(); // Создать новый файл
        } else {
            // Если файл существует, прочитайте содержимое файла
            phone.readBooks();
        }
        phone.operator();
    }


    public void operator() throws IOException {

        while (status) {
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("  1. Новый   2. Удалить   3. Обновить   4. Запросить все   5. Сохранить   0. Выход");
            System.out.println("---------- Телефонная книга ----------");
            System.out.println("Пожалуйста, введите номер, чтобы выбрать соответствующую функцию:");
            String selected = sc.next();
            switch (selected) {
                case "1":
                    // Новый
                    addBook();
                    break;
                case "2":
                    // Удалить
                    delete(); // Удалить из списка
                    break;
                case "3":
                    // Обновление
                    update();
                    break;
                case "4":
                    // Запрашиваем все
                    findAll();
                    break;
                case "5":
                    saveBook();
                    break;
                case "0":
                    // Выход
                    sc.close();
                    status = false;
                    break;
            }
        }
    }

    private void update() throws IOException {

        System.out.println("Пожалуйста, введите имя учетной записи для изменения:");
        String unam = sc.next();
        System.out.println("Введите измененный номер:");
        String unum = sc.next();
        for (Person bk : persons) {
            if (bk.getName().equals(unam)) {
                bk.setNum(unum);
                bk.setTimestamp(Instant.now());

                System.out.println("Изменено успешно !");
            }
        }

    }


    private void delete() {
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

    private void findAll() {
        for (Person bk : persons) {
            System.out.println(bk.toString());
        }
    }

    private void addBook() {

        System.out.println("Пожалуйста, введите имя:");
        tname = sc.next();
        System.out.println("Пожалуйста, введите номер телефона:");
        tnum = sc.next();

        Person bk = new Person(tname,tnum,Instant.now());  //   Instant.now()
        persons.add(bk);
        System.out.println(bk);
        System.out.println("Успешно добавлено !");
    }

    public void readBooks() {
        // читаем информацию о файле
        FileInputStream filein; // Поток ввода байта файла
        try {
            filein = new FileInputStream("files/phoneBook.txt"); // Создать объект класса FileInputStream в соответствии с путем.
            if (filein.available() == 0) {
                System.out.println("Содержимое телефонной книги пустое, главная страница скоро будет загружена ...");
            } else {
                BufferedReader br = new BufferedReader(new InputStreamReader(filein)); // InputStreamReader является агентом преобразования между потоком символов и потоком байтов, BufferedReader является потоком символов, а filein является байтом файла течь
                String line = null;
                Person bk = null;
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(","); // line.split (); // Вырезать строку.

                    bk = new Person(str[0], str[1], timestamp);
                    persons.add(bk);
                    bk = null;
                }
                filein.close(); // Закрыть поток ввода байтов
                br.close(); // Закрыть буфер депозита
                System.out.println("Телефонная книга загружена, вы можете выполнять операции с данными ...");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //e.printStackTrace (); предназначен для вывода информации о ненормальном стеке с указанием причины ошибки.
        } catch (IOException e) {// является подклассом Exception, IOException - это входное или выходное исключение (т.е. исключение при записи и чтении).
            e.printStackTrace();
        }
    }


    private void saveBook() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("files/phoneBook.txt"));
// Может выводить построчно
            for(Person bk:persons) {
                bw.write(bk.getName()+","+bk.getNum()+ ","+ bk.getTimestamp());
                bw.write("\r\n");
            }
            bw.flush (); // Очистить кеш
            System.out.println ("Сохранить успешно");
            bw.close();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
}

//    public static void main(String[] args) throws Exception {

//        ObjectMapper mapper = new ObjectMapper();
//
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(LocalDate.class, new LocalDateSerializer());
//        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//        mapper.registerModule(module);


//        List<Person> persons = Arrays.asList(
//                new Person("Jack", "1233456", LocalDate.of(2000, 5, 2)),
//                new Person("Vasiliy", "3234345", LocalDate.of(1990, 4, 12)),
//                new Person("Anna", "5454545", LocalDate.of(1996, 1, 20))
//        );







//
//    String personsJson = mapper.writeValueAsString(persons);
//      System.out.println(personsJson);

//        List persons2 = mapper.readValue(personsJson, List.class);
//        System.out.println(persons2.get(0).getClass().getName());
//        System.out.println(persons2);

 //       List<Person> persons3 = mapper.readValue(personsJson, new TypeReference<List<Person>>() {});
//        System.out.println(persons3.get(0).getClass().getName());
//        System.out.println(persons3);

