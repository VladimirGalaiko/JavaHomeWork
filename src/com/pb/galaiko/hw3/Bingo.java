package com.pb.galaiko.hw3;

import sun.font.DelegatingShape;

import java.util.Scanner;

public class Bingo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int i = (int) (Math.random() * 100 + 1);
         System.out.println(+i); // загаданное число
        int counter = 0;

        System.out.println("Я загадал число от 0 до 100. Угадайте его. Если захотите выйти из игры введите: 101 ");

        while (true) {
            counter++;
            System.out.println("Введите число: ");

            int a = scan.nextInt();
            if (a == 101) {
                System.out.println("EXIT");
                break;
            } else if (a == i) {
                System.out.println("Bingo! Вы угадали. Колличество попыток :" + counter);
                break;
            } else if (a > i) {
                System.out.println("Загаданное число меньше ");}

            else if (a < i) {
                System.out.println("Загаданное число больше ");}
            }
        }
    }


