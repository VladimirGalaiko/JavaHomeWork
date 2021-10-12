package com.pb.galaiko.hw2;

import java.util.Scanner;

public class Calculator {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        int x;
        int y;
        String symbol;

        x = scan.nextInt();
        y = scan.nextInt();
        symbol = scan.next();
        System.out.println("x = " + x + " y = " + y + " symbol = " + symbol);
    }
}
