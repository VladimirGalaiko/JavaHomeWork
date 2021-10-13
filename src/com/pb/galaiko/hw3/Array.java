package com.pb.galaiko.hw3;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        int[] mas = new int[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Введите 10 целых чисел:");
        for (int i = 0; i < 10; i++) {
            mas[i] = input.nextInt();
        }
        System.out.println("Вывод массива на экран: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("[ ]= " + mas[i]);
        }

        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (mas[i] > 0) {
                counter++;}
        }
        int sum = 0;
        for (int i = 0; i < 10; i++){
            sum = sum + mas[i];}
        System.out.println("Колличество положительных елементов : " + counter);
        System.out.println("Сумма всех елементов масива: " + sum);

        boolean sort = false;
        int obmen = 0;

        while (!sort) {
            sort = true;
            for (int i = 0; i < 9; i++) {
                if (mas[i] > mas[i + 1]) {
                    sort = false;

                    obmen = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = obmen;}
                }
        }
            System.out.println("Вывод массива на экран после сортировки: ");
            for (int i = 0; i < 10; i++) {
                System.out.println("[ ]= " +mas[i]);
        }
    }
}



