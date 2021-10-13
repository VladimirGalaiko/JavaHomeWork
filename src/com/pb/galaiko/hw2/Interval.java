package com.pb.galaiko.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {

        System.out.print("Введите целое число:");
        Scanner mem = new Scanner(System.in);
        int i = mem.nextInt();

        if (i >= 0 && i <= 14) {
            System.out.print("Число входит в диапазон: [0-14]");
        } else if (i >= 15 && i <= 35) {
            System.out.print("Число входит в диапазон: [15-35]");
        } else if (i >= 36 && i <= 50) {
            System.out.print("Число входит в диапазон: [36-50]");
        } else if (i >= 51 && i <= 100) {
            System.out.print("Число входит в диапазон: [51-100]");
        }else {
            System.out.print("Число не входит ни в один из диапазонов:" +
                              " [0 -14] [15 - 35] [36 - 50] [51 - 100]." );
        }
    }
}


