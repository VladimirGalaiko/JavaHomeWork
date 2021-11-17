package com.pb.galaiko.hw8;

public class WrongLoginException extends Exception {

       public WrongLoginException(String msg){
        super("Логин не корректный");

    }

}
