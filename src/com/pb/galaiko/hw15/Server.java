package com.pb.galaiko.hw15;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


public class Server {

    public static final int port = 8567;
    public static LinkedList<SendServer> serverList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);


        System.out.println("Server Started");
        try {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                try {

                serverList.add(new SendServer(clientSocket));
                } catch (IOException e) {
                    clientSocket.close();
                }
            }
        } finally {
            serverSocket.close();
        }
    }
}