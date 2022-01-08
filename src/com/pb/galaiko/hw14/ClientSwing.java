package com.pb.galaiko.hw14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

import static java.lang.System.out;

public class ClientSwing extends JFrame implements ActionListener {
    private static final String ipadres = "172.0.0.1";
    private static final int port = 8567;
    private static final int shirina = 600;
    private static final int vysota = 400;
    private Socket server;// =  new Socket(ipadres, port);


    public static void main(String[] args) throws IOException {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ClientSwing();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private  final JTextArea log = new JTextArea();
    private final JTextField nic = new JTextField("me");
    private final JTextField finput = new JTextField();

    private CLconnection connect;


    private ClientSwing() throws IOException {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // закрытие крестиком
        setSize(shirina,vysota);
        setLocationRelativeTo(null); // окно по середине
       // setAlwaysOnTop(true);

        log.setEnabled(false);
        log.setLineWrap(true);
        add(log, BorderLayout.CENTER);

        finput.addActionListener(this);
        add(finput, BorderLayout.SOUTH);
        add(nic, BorderLayout.NORTH);

        setVisible(true);
        connect = new CLconnection(server);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = finput.getText();
        if(msg.equals("")) return;
        finput.setText(null);
        try {
            connect.sendString(finput.getText() + ": " +msg);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    private synchronized void printMsg (String msg){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                log.append(msg + "\n");
                log.setCaretPosition(log.getDocument().getLength());

            }
        });
    }

}
