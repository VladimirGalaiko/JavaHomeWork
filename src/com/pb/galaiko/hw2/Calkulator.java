package com.pb.galaiko.hw2;

import java.util.Scanner;

public class Calkulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        int y;
        int res;
        char oper;

        System.out.print("Введите операцию:(+,-,*,/): ");
        oper = scan.next().charAt(0);
        System.out.print("Введите первое число: ");
        x = scan.nextInt();
        System.out.print("Введите второе число: ");
        y = scan.nextInt();

        boolean correct = true;

        switch (oper)  {
            case '+':
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
            case '*':
                res = x * y;
                break;
            case '/':
                if(y == 0)
                    System.out.print("Делить на ноль нельзя!");
                res = x / y;
                break;
            default:
                res = 0;
                correct = false;

        }
        System.out.println(correct ? "Ответ:" + res: " не верная операция ");
    }
}