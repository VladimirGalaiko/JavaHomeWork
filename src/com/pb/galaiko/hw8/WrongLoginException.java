package com.pb.galaiko.hw8;

public class WrongLoginException extends Exception {
      public void getMes() {
          System.out.println("Логин не корректный!!! Длинна должна быть от 5 до 20 символов." +
                  " Login должен содержать только латинские буквы и цифры");
          }
    public void getMesss(){
        System.out.println("Логин или Пароль не совпадают - попробуйте еще раз");
    }
}
