package IOtest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Ssend implements Runnable{
    private BufferedReader br;
    private DataOutputStream dos;
    private Socket socket;
    private String name;

    public Ssend(Socket socket,String name){
        this.socket = socket;
        this.name = name;
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(this.socket.getOutputStream());
            send(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run (){
        while(true){
            try {
                String msg=br.readLine();
                if(!msg.equals("")){
                    send(msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
