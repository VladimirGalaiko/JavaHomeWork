package com.pb.galaiko.hw9;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class FileNumbers {


    public static void main(String[] args) throws IOException {

        createNumbersFile();

        System.out.println("Вывод на консоль созданного файла заполненного случайными целыми числами от 1 до 99 :  ");
        Path path = Paths.get("files/numbers.txt");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String s : lines) {
            System.out.print(" " + s + "\n");
        }

        System.out.println();

        createOddNumbersFile();

        System.out.println("Вывод, с заменой четных чисел на (0): ");
        Path path2 = Paths.get("files/odd-numbers.txt");
        List<String> lines2 = Files.readAllLines(path2, StandardCharsets.UTF_8);
        for (String s : lines2) {
            System.out.print(" " + s + "\n");
        }
    }


    private static void createNumbersFile() {

        try (Writer wr = new FileWriter("files/numbers.txt")) {
            int line, i, j;
            Random r = new Random();
            line = r.nextInt(100);
            for (i = 0; i < 10; i++) {
                for (j = 0; j < 10; j++) {
                    line = r.nextInt(100);
                    wr.write(line + " ");
                }
                wr.write("\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка...");
        }
    }

    private static void createOddNumbersFile() {

        try (Scanner in = new Scanner(new File("files/numbers.txt")); // "try с ресурсами"
             PrintWriter out = new PrintWriter(new FileWriter("files/odd-numbers.txt"))) {

            while (in.hasNextLine()) {
                Scanner line = new Scanner(in.nextLine());
                while (line.hasNext()) {
                    int data = line.nextInt();
                    if (data % 2 == 0) {
                        data = 0;
                    } else
                        String.format("");
                    out.print(data + " ");
                }
                out.println();
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
