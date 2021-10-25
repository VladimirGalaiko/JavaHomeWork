package com.pb.galaiko.hw5;

public class Book {
         String name;
         String avtor;
         String god;


       public Book(String name, String avtor, String god) {
              this.name =  name;
              this.avtor = avtor;
              this.god = god;
       }



       public String getKnigi() {
              return "" +
                     "Название: " + name +
                     ". Автор: " + avtor +
                     " Год издания: " + god +
                     "";
       }


}
