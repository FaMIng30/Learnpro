package wechat;



import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable {
    private Socket client;
    boolean isRunning=true;
    private DataInputStream dis;

    public Receive(Socket client) {
        this.client=client;
        try {
            dis=new DataInputStream(this.client.getInputStream());


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private String  receive() {
        String msg="";
        try {

            msg=dis.readUTF();

            return msg;
        } catch (IOException e) {
            e.printStackTrace();
            //release();
        }
        return null;
    }
//
//    private void release() {
//        isRunning =false;
//        Utill.close(dis,client);}
    @Override
    public void run() {
        while(true){

            String msg=receive();

            if(!msg.equals(""))
                System.out.println(msg);



        }

    }


}
