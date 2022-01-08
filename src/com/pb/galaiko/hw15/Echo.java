package com.pb.galaiko.hw15;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class Echo implements ActionListener, Runnable {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8567;
    private final JFrame f = new JFrame();
    private final JTextField tf = new JTextField(25);
    private final JTextArea ta = new JTextArea(15, 25);
    private final JButton send = new JButton("Send");
    private volatile PrintWriter out;
    private Scanner in;
    private Thread thread;



    public Echo() {
        f.setTitle("Echo " );
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getRootPane().setDefaultButton(send);
        f.add(tf, BorderLayout.NORTH);
        f.add(new JScrollPane(ta), BorderLayout.CENTER);
        f.add(send, BorderLayout.SOUTH);
        f.setLocation(500, 300);
        f.pack();
        send.addActionListener(this);
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        DefaultCaret caret = (DefaultCaret) ta.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        thread = new Thread(this);

        f.setVisible(true);
        thread.start();
    }

    public void actionPerformed(ActionEvent ae) {
        String s = tf.getText();
        if (out != null) {
            out.println(s);
        }
        display(s);
        tf.setText("");
    }

    public void run() {
        try {
            Socket socket;
            socket = new Socket(HOST, PORT);

            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            display("Connected");
            while (true) {
                display(in.nextLine());
            }
        } catch (Exception e) {
            display(e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    private void display(final String s) {
        EventQueue.invokeLater(() -> ta.append(s + "\u23CE\n"));
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Echo());
    }
}