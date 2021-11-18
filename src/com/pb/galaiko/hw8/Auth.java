package com.pb.galaiko.hw8;


import java.util.regex.Pattern;

public class Auth {
    private static String login;
    private static String password;
    private String confirmPassword;
    private String login2;
    private String password2;



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getLogin2() {
        return login2;
    }

    public void setLogin2(String login2) {
        this.login2 = login2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!Pattern.matches("[a-zA-Z0-9]{5,20}",login)) {
            throw new WrongLoginException("Login не корректный!!! Длинна должна быть от 5 до 20 символов. " +
                                          "Login должен содержать только латинские буквы и цифры");
        }
        if (!Pattern.matches("[a-zA-Z0-9_]{5,}",password)) {
            throw new WrongPasswordException();
        }
        if (confirmPassword.equals(password)) {
            System.out.println("Поздравляем! Вы успешно зарегистрировались на сайте : ");
        } else {
            System.out.println("Пароли  не совпадает - попробуйте еще раз");
        }
    }

    public void signIn(String login2, String password2) throws WrongLoginException, NullPointerException {
        if (login.equals(login2) &&  password.equals(password2)) {
            System.out.println("Успешный вход!");
        }
        else {
            throw new WrongLoginException("Login или Password не совпадают - попробуйте еще раз");
        }

    }
}















//- signUp (регистрация на сайте) принимающий login, password, и confirmPassword.
//        Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только
//        латинские буквы и цифры. Если логин не соответствует требованиям нужно выбросить WrongLoginException.
//        Проверяет параметр password, длина более 5, только латинские буквы и цифры и знак подчеркивания.
//        Также password и confirmPassword должны совпадать. Если password не соответствует требованиям нужно выбросить
//        WrongPasswordException.  Если проверки все пройдены успешно записать в свои поля значение login и password.
//        Так сохраняем пользователя :)
//
//        - signIn (вход на сайт) принимающий login и password.
//        Проверяет что login и password соответствуют значениям из полей класса.
//        Если нет - выбрасывает исключение WrongLoginException.
//
//        WrongPasswordException и WrongLoginException - пользовательские классы исключения
//        с двумя конструкторами – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.
