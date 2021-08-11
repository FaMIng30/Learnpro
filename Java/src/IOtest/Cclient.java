package IOtest;

import java.io.*;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cclient {
    public static void main (String[] args) throws IOException{

        Socket client = new Socket("localhost", 8998);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
//        DataInputStream dis = new DataInputStream(client.getInputStream());

//        while (true) {
//            String msg = br.readLine();
//            dos.writeUTF(msg);
//            dos.flush();
//            String msh = dis.readUTF();
//            System.out.println(msh);
//        }
        new Thread(new Ssend(client,"name1")).start();
        new Thread(new Rrecieve(client)).start();
    }
}