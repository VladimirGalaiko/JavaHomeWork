package com.pb.galaiko.hw15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;


public class AddClient  implements ActionListener , Runnable {

    private static final String ipadres = "127.0.0.1";
    private static final int port = 8567;
    private final JFrame gframe = new JFrame();
    private final JTextField finput = new JTextField(25);
    private final JTextArea log = new JTextArea(15, 25);
    private final JButton send = new JButton("Send");
    private volatile PrintWriter out;
    private Scanner scan;
    private Thread thread;


    private AddClient() {
        gframe.setTitle("AddClient " );

        gframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gframe.getRootPane().setDefaultButton(send);
        gframe.add(finput, BorderLayout.NORTH);
        gframe.add(new JScrollPane(log), BorderLayout.CENTER);
        gframe.add(send, BorderLayout.SOUTH);
        gframe.setLocation(500, 300);
        gframe.pack();

        send.addActionListener(this);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);

        thread = new Thread(this);
        gframe.setVisible(true);
        thread.start();
   }

    public void actionPerformed(ActionEvent ae) {
        String s = finput.getText();
        if (out != null) {
            out.println(s);
        }
        display(s);
        finput.setText("");
    }
    @Override
    public void run() {
        try {
            Socket socket;
            socket = new Socket(ipadres, port);

            scan = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            display("Connected");
            while (true) {
                display(scan.nextLine());
            }
        } catch (Exception e) {
            display(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private void display(final String s) {
        EventQueue.invokeLater(() -> log.append(s + "\u23CE\n"));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new AddClient());
    }
}