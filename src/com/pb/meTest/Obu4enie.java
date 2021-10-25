package com.pb.meTest;

public class Obu4enie {
    public static void main(String[] arg) {
        System.out.println("HelloWorld");
        String message = "HelloWorld2";
        System.out.println(message);
        float i = 6;
        float j = 7;
        double answer = i / j;
        System.out.println(answer);

        String stringAnswer = message +" " + answer;
        System.out.println(stringAnswer);
        boolean isMoreThanOne;
           if  (answer > 1){
               isMoreThanOne = true;
           }
           else {
               isMoreThanOne = false;
           }
               System.out.println(stringAnswer + " " + isMoreThanOne);



    }
}

