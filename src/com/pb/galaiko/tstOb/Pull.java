package com.pb.galaiko.tstOb;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pull {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exs = Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10; i++) {
            exs.submit(new Work(i));

        }
        exs.shutdown();

         exs.awaitTermination(1, TimeUnit.DAYS);


    }
}


class Work implements Runnable{
    private int  id;

    public Work(int id) {
        this.id =id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Ворк " +id + " завершил работу ");
    }
}
