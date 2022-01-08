package com.pb.galaiko.tstOb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server2  {
    static class Handler implements Runnable {
        private final Socket socket;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String clientMessage;

                // цикл ожидания сообщений от клиента
                System.out.println("Ожидаем сообщений");
                while ((clientMessage = in.readLine()) != null) {
                    if ("exit".equalsIgnoreCase(clientMessage)) {
                        break;
                    }
                    out.println(LocalDateTime.now() +"  " + "Сервер: " + clientMessage);
                    System.out.println(clientMessage);
                }

                System.out.println("Закрываем соединение с клиентом");
                out.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 8025;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен на порту : " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        // В цикле ждем запроса клиента
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}