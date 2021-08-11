package IOtest;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Rrecieve implements Runnable {
    private DataInputStream dis;
    private Socket socket;
    public Rrecieve(Socket socket){
        this.socket=socket;
        try {
            dis=new DataInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run (){
        while (true){
            String msg= null;
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!msg.equals(""))
                System.out.println(msg);
        }

    }
}
