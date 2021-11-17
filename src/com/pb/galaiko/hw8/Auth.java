package com.pb.galaiko.hw8;

public class Auth {
    private String login;
    private String password;
    // String confirmPassword;

 public Auth(String login, String password) {
           this.login = login;
           this.password= password;
       //this.confirmPassword = confirmPassword;
    }
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

    //String login, String password, String confirmPassword
    public void signUp() throws WrongLoginException, WrongPasswordException {
        if (login.length() < 5 || login.length() > 20) {
            throw new WrongLoginException("Логин не корректный");
        }
        if (password.length() < 5) {
            throw new WrongPasswordException("Пароль не корректный");
        }
        String confirmPassword = password;
        if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль не совпадает");
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
