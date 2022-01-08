package com.pb.galaiko.hw14;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;




public class RewriteClient implements ActionListener {
    /**
     * @param args the command line arguments
     */
    Socket connection;
    JButton send;
    JTextField textS;
    JTextArea winDia;


    public static void main(String[] args) {
        RewriteClient k = new RewriteClient();

        k.go();

    }

    void go() {
        JFrame frame = new JFrame("Client");
        JPanel Up = new JPanel();
        JPanel Dp = new JPanel();
        send = new JButton("send");
        textS = new JTextField(15);
        winDia = new JTextArea(10, 20);

        frame.setLayout(new BorderLayout());

        frame.add(Up, BorderLayout.NORTH);
        frame.add(Dp, BorderLayout.SOUTH);

        Up.add(winDia);
        Dp.setLayout(new BorderLayout());
        Dp.add(textS, BorderLayout.WEST);
        Dp.add(send, BorderLayout.EAST);

        winDia.setEditable(false);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        send.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        winDia.setText(winDia.getText()+ "\nClient: " +  textS.getText());
        PrintWriter writer;
        try {


            connection = new Socket("172.0.0.1", 8025);

            if(connection.isConnected()) {
                OutputStreamWriter out = new OutputStreamWriter( connection.getOutputStream());
                InputStreamReader in = new InputStreamReader (connection.getInputStream());

                BufferedReader reader = new BufferedReader(in);
                writer = new PrintWriter(out);


                writer.print(textS.getText());
                writer.close();
            }

        } catch (IOException ex) {

        }
        textS.setText(null);


    }
}
