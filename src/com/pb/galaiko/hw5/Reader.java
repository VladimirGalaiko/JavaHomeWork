package com.pb.galaiko.hw5;

public class  Reader  {


       String fio;
       int numchitbilet ;
       String facuktet;
       String birthday;
       String telefon;
       int kolknig;


       public  Reader(String fio, int numchitbilet, String facultet, String birthday, String telefon){
              this.fio = fio;
              this.numchitbilet = numchitbilet;
              this.facuktet = facultet;
              this.birthday = birthday;
              this.telefon = telefon;
       }



         public  void takeBook(int kolknig ) {
              System.out.println(fio + " Взял книги, колличество : " + kolknig);
       }
         public  void takeBook(Book... takedBooks) {
             System.out.println (fio + " Взял книги : " + takedBooks[0].name +
                   ", " + takedBooks[1].name + ", "  + takedBooks[2].name);
             System.out.println(fio + " Взял книги : " + takedBooks[0].name + "("+ takedBooks[0].avtor + ", "
                            + takedBooks[0].god + ")," + takedBooks[1].name + "("+  takedBooks[1].avtor + ", "
                            + takedBooks[1].god + ")," + takedBooks[2].name + "("+ takedBooks[2].avtor + ", "
                            + takedBooks[2].god + ")");
       }

         public  void returnBook(int kolknig ){
           System.out.println(fio + " Вернул книги, колличество : " + kolknig);
         }
         public  void returnBook(Book... returnBook){
               System.out.println(fio + " Вернул книги : " + returnBook[0].name +
                       ", " + returnBook[1].name + ", " + returnBook[2].name);
               System.out.println(fio + " Вернул книги : " + returnBook[0].name +"("+ returnBook[0].avtor +
                            ", "+ returnBook[0].god + ")," + returnBook[1].name +"("+ returnBook[1].avtor + ", " +
                                  returnBook[1].god + ")," + returnBook[2].name +"("+ returnBook[2].avtor + ", " +
                                  returnBook[2].god + ")");
       }


         public String getPosetiteli() {
              return "" +
                      "ФИО: " + fio +
                      ". Номер читательского билета: " + numchitbilet +
                      ". Факультет: " + facuktet +
                      ". Дата рождения: " + birthday + ". Телефон "
                      + telefon +"";
       }

}

