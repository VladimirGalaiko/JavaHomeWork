package com.pb.galaiko.hw14;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Mainchat {
    private MainchatThread mt;

    public void ShowUI(){

        JFrame jf=new JFrame();
        jf.setTitle ( "Клиент");
        jf.setSize(500,500);
        jf.setLocation(400, 300);
        jf.setLayout(new FlowLayout());
        jf.setDefaultCloseOperation(3);
        JButton jb = new JButton ("Подключиться к серверу");

        JButton jb1 = new  JButton ("Отправить");
        final JTextField jte1=new JTextField(30);
        final JTextArea jta=new JTextArea(20,40);
        jf.add(jb);
        jf.add(jb1);
        jf.add(jte1);
        jf.add(jta);
        ActionListener al=(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String s=e.getActionCommand();
                if (s.equals ("Подключиться к серверу")) {
                    try {
                        mt=new MainchatThread("localhost",8567,jta);
                        if(mt.runing()){
                            mt.start();
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
                // Отправить сообщение другим
                 if(s.equals ( "отправить")) {
                    String msg=jte1.getText();
                    jta.append ("Я сказал:" + msg + "\r \n");
                    mt.sendMsg(msg);
                    jte1.setText("");
                }
            }
        });
        jb.addActionListener(al);
        jb1.addActionListener(al);
        jf.setVisible(true);
    }

    public static void main(String[] args){
        Mainchat ms=new Mainchat();
        ms.ShowUI();
    }

}