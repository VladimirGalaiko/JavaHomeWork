package com.pb.galaiko.tstOb;

public class PhraseOMatic {
    public static void main(String[] args){
        String[] wordListOne = {"Круглосуточных", "Трех-звенный", "30000-футовый", "Взаимный", "Обоюдный выиграш", "Умный",
        "Проникающий"};
        String[]  wordListTwo = {"трудный", "сетевой", "общий", "фирменный", "ориентированный", "совместный","общий",
        "центральный", "распределенный"};
        String[] wordListThree = {"процесс", "талант", "подход", "портал", "обзор", "образец", "период времени", "тип структуры",
        "пункт следования"};

        int oneLength = wordListOne.length;
        int twolength = wordListTwo.length;
        int threeLength = wordListThree.length;

        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twolength);
        int rand3 = (int) (Math.random() * threeLength);

        String phraze = wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3];
        System.out.println("Все что нам нужно, - єто " + phraze);
        //или можно так  System.out.println(wordListOne[rand1] + " " + wordListTwo[rand2] + " " + wordListThree[rand3]);

    }
}
