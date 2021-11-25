package com.pb.galaiko.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> numBox = new NumBox<>(3);
       try {
           numBox.add(0, 2);
           numBox.add(1, 5);
           numBox.add(2, 10);
//         numBox.add(3, 1);                 Что бы выбросить исключения.
       }
       catch (ArrayIndexOutOfBoundsException e){
           System.out.println("Величина numBox max '3'- числа!");
           return;
       }


        Number nInt1 = numBox.get(0);
        Number nInt2= numBox.get(1);
        Number nInt3 = numBox.get(2);

        System.out.println("Числа Integer в numBox: " +nInt1+ ", " +nInt2+ ", " +nInt3);

        System.out.println("Сумма всех элементов массива: " + numBox.sum());
        System.out.println("Количество элементов: " + numBox.length());
        System.out.println("Среднее арифметического среди элементов массива: " + numBox.average());
        System.out.println("Максимальный элемент массива: " + numBox.max());

        System.out.println();

        NumBox<Float> numBox2 = new NumBox<>(3);
        numBox2.add(0, 2.25F);
        numBox2.add(1, 5.9F);
        numBox2.add(2, 5.6F);

        Number nFloat1 = numBox2.get(0);
        Number nFloat2 = numBox2.get(1);
        Number nFloat3 = numBox2.get(2);

        System.out.println("Числа Float в numBox2: " +nFloat1+ ", " +nFloat2+ ", " +nFloat3);


        System.out.println("Сумма всех элементов массива: " + numBox2.sum());
        System.out.println("Количество элементов: " + numBox2.length());
        System.out.println("Среднее арифметического среди элементов массива: " + numBox2.average());
        System.out.println("Максимальный элемент массива: " + numBox2.max());
    }
}


//   протестировать полученный класс на примере NumBox<Float> и NumBox<Integer>.