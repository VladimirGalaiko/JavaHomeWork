package com.pb.galaiko.hw9;



import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class FileNumbers {


    public static void main(String[] args) throws IOException {

        createNumbersFile();
        createOddNumbersFile();

    }


    private static void createNumbersFile() {

        try (Writer wr = new FileWriter("files/numbers.txt")) {
            int line;
            int i;
            int j;
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
            System.out.println("ошибка");
        }
    }

    private static void createOddNumbersFile() {
//        Path path = Paths.get("files/numbers.txt");
//        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
//        for (String s : lines) {
//            System.out.print(" " + s + "\n");
        try (Scanner in = new Scanner(new File("files/numbers.txt")); // "try с ресурсами"
             PrintWriter out = new PrintWriter(new FileWriter("files/odd-numbers.txt"))) {
            System.out.println("Вывод, с учетом замены целых четных чисел на '0':");
            while (in.hasNextLine()) {
                Scanner line = new Scanner(in.nextLine()); // Одна строка файла
                while (line.hasNextInt()) {             // Разберем ее на числа
                    int data = line.nextInt();          // Очередное число
                    if (data % 2 == 0) {                // Если чётное
                        System.out.format("%d -> 0, ", data); // Чтоб было видно, что делается
                        data = 0;                       // Заменим его нулём
                    } else
                        System.out.print(data + ", ");  // Чтоб было видно, что делается
                    System.out.print(data + " ");
                }
                System.out.println();                  // Строка закончена -- перенос строки в вых. файл
                System.out.println();                  // и на экране
            }
        } catch (IOException x) {
            System.out.println("Ошибка: " + x);
        }
    }
}
//        try (Reader wr = new FileReader("files/numbers.txt");
//             Writer wr2 = new FileWriter("files/odd-numbers.txt")) {
//
//                while ((c = wr.read()) != -1)
//                wr2.write(c);
//
//            } catch(IOException e){
//                e.getStackTrace();
//            }




