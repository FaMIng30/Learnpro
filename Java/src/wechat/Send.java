package wechat;

import java.io.*;
import java.net.Socket;

public class Send implements Runnable {
    private DataOutputStream dos;
    private DataInputStream dis;
    private BufferedReader console;
    private Socket client;
    boolean isRunning = true;
    private String name;

    public Send (Socket client, String name){
        this.client = client;
        this.name = name;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(this.client.getOutputStream());
            send(name);
        } catch (IOException e) {
//            release();
            e.printStackTrace();
        }
    }

    //发送
    private void send (String msg){

        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
//            release();
    }
    }

    //释放资源
//    private void release (){
//        Utill.close(dis, dos, client);
//    }

    //控制台获取输入内容
    private String getConsole (){
        try {
            return console.readLine();
        } catch (IOException e) {
//            release();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void run (){
        while (isRunning) {
            try {
                String msg = console.readLine();
                if (!msg.equals(""))
                    send(msg);
                 else
                     send(" ");
            } catch (IOException e) {
//                release();
                e.printStackTrace();
            }


        }

    }
}