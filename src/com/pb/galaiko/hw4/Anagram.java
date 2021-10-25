package com.pb.galaiko.hw4;



import java.util.Scanner;
public class Anagram {

    public static String s1 = "";
    public static String s2 = "";

    public static void main(String[] args) {

        add("Ввод данных");
        vMassAndSort("Сортировка и результат");}

    public static void add(String vVodTeksta) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст:");
        s1 = scan.nextLine();
        System.out.println("Введите к нему анаграмму:");
        s2 = scan.nextLine();
    }

    public static void vMassAndSort(String vMass) {
        char[] mas1 = s1.replaceAll("\\p{Punct}|\\s", "").toUpperCase().toCharArray();
        char[] mas2 = s2.replaceAll("\\p{Punct}|\\s", "").toUpperCase().toCharArray();


        for (int i = mas1.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas1[j] > mas1[j + 1]) {
                    char tmp = mas1[j];
                    mas1[j] = mas1[j + 1];
                    mas1[j + 1] = tmp;
                }
            }
        }
        for (int i = mas2.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (mas2[j] > mas2[j + 1]) {
                    char tmp = mas2[j];
                    mas2[j] = mas2[j + 1];
                    mas2[j + 1] = tmp;
                }
            }
        }
         System.out.println("Вывод на экран после сортировки: ");
         System.out.println(mas1);
         System.out.println(mas2);

         String newMas1 = String.valueOf(mas1);
         String newMas2 = String.valueOf(mas2);


        boolean aNag = true;{
            if (newMas1.equals(newMas2))
                System.out.println("Результат сравнения: Єто анаграмма");
            else
                System.out.println("Результат сравнения: Это не анаграмма");
        }
    }

 }







