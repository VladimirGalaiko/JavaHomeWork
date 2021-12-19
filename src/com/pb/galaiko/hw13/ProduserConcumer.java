package com.pb.galaiko.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class ProduserConcumer {
    private int maxLimit = 10;
    private Queue<Integer> pc = new LinkedList<>();
    private Object lock = new Object();


    public void produce() throws InterruptedException {

        int coorent = 0;
        while (true) {
            System.out.print("Заполняем... " );
            synchronized (lock) {
                while (pc.size() == maxLimit) {
                    System.out.println("[] -  Заполнен!!! ");
                    System.out.println("Ждем очистки......");
                    lock.wait();
                }
                pc.offer(coorent++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2500);
        while (true) {
            synchronized (lock) {
                while (pc.size() == 0) {
                    lock.wait();
                }

                System.out.println("Вывод на консоль заполненого массива [] -> " + pc);
                pc.clear();
                System.out.println(pc + " - " + "Очищен! ");

                lock.notify();
            }
            Thread.sleep(2500);
        }
    }
}
