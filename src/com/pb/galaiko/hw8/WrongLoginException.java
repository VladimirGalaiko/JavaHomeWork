package com.pb.galaiko.hw8;

public class WrongLoginException extends Exception {
    public WrongLoginException(String message) {
        super(message);

    }

    public void getMesss() {
        System.out.println("Login или Password не совпадают - попробуйте еще раз");
    }
}
