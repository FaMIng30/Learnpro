package IOtest;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.Date;

public class FileInOutStream {

    /*
     流的分类
     按流向分： 输入流 （inputStream/Reader）  输出流 (OutputStream/Writer) 输入还是输出是相对的，这里的输入输出相对的是程序（内存）即 ：磁盘（或其他输入设备）----->程序（内存） 为输入流，  程序------->磁盘为输出流
     按作用对象分：节点流 (作用于数据源)  处理流（作用于其他流）
     按作用对象类型分：字节流（inputStream/outputStream）   字符流（Reader/Writer）
     */

    //注意：io流中一般情况下异常不要向外抛，因为如果程序发生异常，异常外抛程序就会终止后面的运行，就会让原本打开的流不关闭，一直打开导致溢出。
    //所以一般通过捕获，在finally中关闭流的操作  ，关闭流需要做判空

   //关于有缓冲流为什么还要定义字节数组的原因：缓冲流和字节数组作用的位置不一样，普通的字节流读取文件是从硬件（存储介质）中读取，与硬件打交道。CPU使用数据是就要通过字节流从硬件中的去数据
    //IO速度慢，缓冲流是在CPU和硬件资源之间建立一个缓冲区，缓冲区位于内存中。由字节流将数据读取到缓冲区中，CPU直接从内存中读取数据，加快的IO速度。缓冲区的大小需要适当，过大的缓冲区会导致内存浪费，
    //过小的空间会没有足够的数据提供给CPU，当前缓冲区的大小为8192个字节.

    //缓冲区的创建： 字节流定义 byte类型数组，字符流定义char类型数组
    //文件的复制
    public static void main (String[] args) throws IOException{
//       long start= System.currentTimeMillis();
//        //创建文件对象
//        File srcfile= new File("D:\\JAVA\\io1\\hi2.txt");
//        File desfile= new File("D:\\JAVA\\IO2\\hi2.txt");
//        //获取流
//          FileReader fileInputStream=new FileReader(srcfile);//需要有文件存在，buffer缓冲流大大提升流的传输速度
//          FileWriter fileOutputStream = new FileWriter(desfile);//不需要有文件存在，会帮你创建,上层文件夹需要存在
//        //创建缓冲区表示一次读取20个字节
//        char[] buffer=new char[20];
//        int length;//
//        while((length=fileInputStream.read(buffer))!=-1){
//            System.out.println(length);
//            fileOutputStream.write(buffer,0,length);
//            fileOutputStream.flush();
//        }
//        System.out.println("复制完成");
//        long end= System.currentTimeMillis();
//        System.out.println("Buffer缓冲流用时"+(end-start));
//        fileInputStream.close();
//        fileInputStream.close();



        long start1= System.currentTimeMillis();
        //创建文件对象
        File srcfile1= new File("D:\\JAVA\\io1\\4.jpg");
        File desfile1= new File("D:\\JAVA\\io1\\4.jpg");
        //获取流
        BufferedInputStream fileInputStream1=new BufferedInputStream(new FileInputStream(srcfile1));//需要有文件存在
        BufferedOutputStream fileOutputStream1 =new BufferedOutputStream(new FileOutputStream(desfile1));//不需要有文件存在，会帮你创建,上层文件夹需要存在

        //创建缓冲区表示一次读取20个字节
        byte [] buffer1=new byte[1024];
        int length1;//
        while((length1=fileInputStream1.read())!=-1){
//           System.out.println(length1);

            fileOutputStream1.write(buffer1,0,length1);
        }
        System.out.println("复制完成");
        fileInputStream1.close();
        fileOutputStream1.close();

//
        long end2= System.currentTimeMillis();
        System.out.println("普通流用时"+(end2-start1));
    }
}
