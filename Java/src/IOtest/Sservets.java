package IOtest;

import com.sun.xml.internal.bind.v2.schemagen.XmlSchemaGenerator;
import wechat.Servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Sservets {
    private static List<Channel> all = new ArrayList<Channel>();

    public static void main (String[] args) throws IOException{
        ServerSocket ser = new ServerSocket(8998);
        boolean isRuning = true;
        System.out.println("服务器连接");
        while (isRuning) {
            Socket clientsocket = ser.accept();
            System.out.println("客户端连接");
            Channel c=new Channel(clientsocket);
            all.add(c);
            new Thread(c ).start();
//            DataInputStream dis = new DataInputStream(clientsocket.getInputStream());
//            DataOutputStream dos = new DataOutputStream(clientsocket.getOutputStream());
//            while (isRuning) {
//                String msg = dis.readUTF();
//                System.out.println(msg);
//                dos.writeUTF(msg);
//                dos.flush();
//            }
//            dis.close();
//            dos.close();

        }
    }
  static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;

      public String getName (){
          return name;
      }

      private String name;
        private Socket client;
        private Channel(Socket client){
            this.client=client;
            try {
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
               this.name=recieve();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public String recieve(){
            String msg="";//处理空指针
            try {
                msg=dis.readUTF();
                return msg;
            } catch (IOException e) {
                e.printStackTrace();
            }
        return null;
        }

       public void send( String msg){
           try {
               dos.writeUTF(msg);
               dos.flush();
           } catch (IOException e) {
               e.printStackTrace();
           }

       }
       //格式：@名字:xxxxxxxx
      //群聊
       public void sendOthers(String msg){
           if (msg.startsWith("@")) {
               int index = msg.indexOf(":");//：的索引
               String priName = msg.substring(1, index);//名字
               String msg1 = msg.substring(index + 1);//信息
               for (Channel other : all) {
                   if (other.getName().equals(priName)) {
                       other.send(this.name + "@你说：" + msg1);
                   } else {
                       other.send(this.name + "@" + other.getName() + "说：" + msg1);

                   }
               }
           }
           else {
               for (Channel other :all){
                   if (other==this){
                       continue;
                   }
                   other.send(this.name+"说："+msg);
               }

                           }
               }

      @Override
      public void run (){
            while(true){
                String msg=recieve();
                System.out.println(msg);
                if(!msg.equals(""))
                    sendOthers(msg);
            }

      }
  }
}

