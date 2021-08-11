package wechat;

import java.io.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名：");
        String name =br.readLine();
        Socket sc=new Socket("localhost",7787);
        // 将Socket对应的输入流包装成BufferedReader
        new Thread(new Send(sc,name)).start();//向服务器发送消息
        new Thread(new Receive(sc)).start();//接受服务器的消息



    }
}
