package com.pb.galaiko.hw8;

public class WrongPasswordException extends Exception{
    public void getMess() {
        System.out.println("Пароль не корректный!!! Требования к паролю:" +
                " более 5 символов, только латинские буквы и цифры и знак подчеркивания");
    }
}
