package com.pb.galaiko.hw8;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message) {
        super("Пароль не корректный или не совпадает");
    }
}
