package com.pb.galaiko.hw4;


import java.util.Scanner;

class CapitalLetter {
    public static void main(String[] args) {

        String enTxt;

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите текст: ");
        enTxt = scan.nextLine();
        System.out.println("Переводим каждоую первую букву текста в верхний регистр: ");
        System.out.println(metod1(enTxt));


    }

    private static String metod1(String enTxt){
            char[] array = enTxt.toCharArray();
                   array[0] = Character.toUpperCase(array[0]);
              for (int i = 1; i < array.length; i++) {
                if (Character.isWhitespace(array[i - 1])) {
                    array[i] = Character.toUpperCase(array[i]);
                }
            }
            return new String(array);
       }
}












