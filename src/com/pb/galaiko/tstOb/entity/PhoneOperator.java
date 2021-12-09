package com.pb.galaiko.tstOb.entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneOperator {
    List <Books> booklist = new ArrayList(); // <> - это универсальный знак, используйте класс ArrayList для создания экземпляра коллекции List
    Scanner sc = new Scanner(System.in);
    boolean status = true;
    private String tname;
    private String tnum;



    public static void main(String[] args) throws IOException {
        PhoneOperator phone = new PhoneOperator(); // Определение объекта PhoneOperator для телефона
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
        for (Books book : booklist) {
            if (book.getName().equals(unam)) {
                book.setNum(unum);
                System.out.println("Изменено успешно !");
            }
        }

    }


    private void delete() {
        System.out.println("Пожалуйста, введите имя контакта для удаления:");
        String dname = sc.next();
        for (int i = 0; i < booklist.size(); i++) {
            Books book = booklist.get(i);
            if (book.getName().equals(dname)) {
                booklist.remove(book);
                System.out.println("Успешно удалено !");
            } else {
                continue;
            }
        }
    }

     private void findAll() {
        // TODO Auto-generated method stub
        for (Books book : booklist) {
            System.out.println(book.showBook());
        }
    }

     private void addBook() {
        // TODO Auto-generated method stub
        System.out.println("Пожалуйста, введите имя:");
        tname = sc.next();
        System.out.println("Пожалуйста, введите номер телефона:");
        tnum = sc.next();
        Books book = new Books(tname, tnum);
        booklist.add(book);
        System.out.println(book.showBook());
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
                Books book = null;
                while ((line = br.readLine()) != null) {
                    String[] str = line.split(","); // line.split (); // Вырезать строку.
                    book = new Books(str[0], str[1]);
                    booklist.add(book);
                    book = null;
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
            for(Books book:booklist) {
                bw.write(book.getName()+","+book.getNum());
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

//"files/phoneBook.txt"