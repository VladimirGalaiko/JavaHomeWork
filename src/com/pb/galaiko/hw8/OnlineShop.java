package com.pb.galaiko.hw8;


import java.util.Scanner;

public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {

        Scanner sc = new Scanner(System.in);


        System.out.println("Придумайте логин пароль и повторите пароль ... ");
        System.out.println("имя пользователя");
        String newlogin = sc.nextLine();
        System.out.println(" введите  пароль");
        String newpassword = sc.nextLine();
        System.out.println(" введите повторно  пароль");
        String confirmPassword = sc.nextLine();
        Auth user = new Auth(newlogin,newpassword);

        try {
            user.signUp();
        } catch (WrongLoginException e1) {
            System.out.println("Логин беда...");
            e1.printStackTrace();
            e1.getMessage();
        } catch (WrongPasswordException e2) {
            System.out.println("Пароль беда ...");
            e2.getMessage();

        }


        user.setLogin(newlogin);
        user.setPassword(newpassword);

        System.out.println(newlogin);
        System.out.println(newpassword);

    }


}


//    Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
//        Обработать исключения методов signUp signIn с помощью блоков try-catch.
