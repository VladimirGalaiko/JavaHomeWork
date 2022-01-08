package com.pb.galaiko.hw15;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

class SendServer extends Thread {

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;


    public SendServer(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": Получен запрос от клиента");
        String clientMessage;

        try {
            while ((clientMessage = in.readLine()) != null) {
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    break;
                }
                System.out.println("Клиент : " + clientMessage);

                for (SendServer vr : Server.serverList) {
                    vr.send(LocalDateTime.now() +"  " + "Сервер: " + clientMessage);
                }
            }
            System.out.println("Закрываем соединение с клиентом");
            out.close();
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void send(String str) {
        try {
            out.write(str + "\r\n");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}