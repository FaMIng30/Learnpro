package wechat;



import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Servers {
    //每一个all对象都是一个Channel
    private static CopyOnWriteArrayList<Channel> all=new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket ss=new ServerSocket(7787);
        System.out.println("服务器已连接------");
        while(true) {
            Socket sver=ss.accept();//阻塞式连接：即获取不到连接时就会一直获取，不会执行下一条语句。直到要为止
            System.out.println("一个客户端已连接-----");
            Channel c=  new Channel(sver);
            all.add(c);
            new Thread(c).start();

        }
    }

    //一个客户代表一个Channel
    static class Channel implements Runnable{
        private DataOutputStream dos;
        private DataInputStream dis;
        private Socket client;
        boolean isRunning=true;
        private String name;
        public Channel(Socket client) {
            this.client=client;
            try {
                //打开输入输出流的通道
                dis=new DataInputStream(client.getInputStream());
                dos=new DataOutputStream(client.getOutputStream());
                this.name=receive();
            } catch (IOException e) {
                // TODO Auto-generated catch block
//                e.printStackTrace();	release();
            }
        }
        //接收客户端消息
        private String  receive() {
            String msg="";
            try {
                msg=dis.readUTF();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
//                release();
            }
            return msg;
        }
        //发送消息
        //将接收到的信息写入内存中
        private void send(String msg) {
            try {
                dos.writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
//                release();
            }
        }
        //群聊
        //私聊：约定格式：@xxx：msg
        private void sendOthers(String msg) {
            boolean isSys=msg.startsWith("@");
            if(isSys) {
                int idex=msg.indexOf(":");
                String pritName=msg.substring(1,idex);//名字
                msg=msg.substring(idex+1);
                for(Channel other:all) {
                    if(other.name.equals(pritName)) {
                        other.send(this.name+"对你说"+ msg);}
                    else {
                        other.send(this.name+"对所有人说"+msg);
                    }
                }

            }

            else {  for(Channel other:all) {
                if(other==this)//自己
                    continue;
                //其他对象发送send信息给自己 ，然后自己的receive接收信息
                //send方法是将信息发给自己的
                /*除了自己以外的Channel对象调用自己的
                 * send方法将信息发给自己
                 * receive、接收
                 */
                other.send(this.name+"对所有人说"+msg);
            }
            }

        }


        //释放资源
//        private void release() {
//            Utill.close(dis,dos,client);
//        }
        @Override
        public void run() {

            while(isRunning) {
                String msg=receive();
                if(!msg.equals(""))
                    sendOthers(msg);
            }

        }

    }
}