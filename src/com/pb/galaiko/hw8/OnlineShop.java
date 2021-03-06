package com.pb.galaiko.hw8;

import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Auth user = new Auth();


        while (true) {
            System.out.println("http : // OnlineShop. com. ua");
            System.out.println();
            System.out.println("------Выберете меню цифрой-------");
            System.out.println("1. Регистрация  2. Вход  3. Выход");
            System.out.println("Сделайте выбор ...");

            String num = sc.nextLine();
            switch (num) {
                case "1":
                    System.out.println(" Регистрация...");
                    System.out.println("Придумайте имя пользователя: ");
                    String login = sc.nextLine();
                    System.out.println("Придумакйте пароль: ");
                    String password = sc.nextLine();
                    System.out.println("Повторите пароль:");
                    String confirmPassword = sc.nextLine();

                    user.setLogin(login);
                    user.setPassword(password);
                    user.setConfirmPassword(confirmPassword);

                    try {
                        user.signUp(login, password, confirmPassword);
                    } catch (WrongLoginException e1) {
                        e1.printStackTrace();
                    } catch (WrongPasswordException e2) {
                        e2.printStackTrace();
                        e2.getMess();
                    }
                    break;

                case "2":

                    System.out.println("Введите имя пользователя: ");
                    String login2 = sc.nextLine();
                    System.out.println("Введите пароль: ");
                    String password2 = sc.nextLine();

                    user.setLogin2(login2);
                    user.setPassword2(password2);


                    try {
                        user.signIn(login2, password2);
                    } catch (WrongLoginException e1) {
                        e1.getMesss();
                    } catch (NullPointerException e3) {
                        System.out.println("Пользователь не найден! Так как еще нет пользователя :D " +
                                " Пожалуйста пройдите регистрацию.");
                    }
                    break;

                case "3":
                    System.out.println("EXIT");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод, пожалуйста, введите заново");
                    break;
            }
        }
    }
}
