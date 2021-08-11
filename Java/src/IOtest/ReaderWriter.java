package IOtest;

import java.io.*;

public class ReaderWriter {
    //字符流 FileReader FileWriter

    public static void main (String[] args) throws IOException{
        File file0 =new File("Java\\resource\\1.jpg");
        File file1 = new File("D:\\JAVA\\io1\\11.jpg");
        //获取流
        FileReader fileReader = new FileReader(file0);
        FileWriter fileWriter = new FileWriter(file1);

        char [] buff = new char[20];
        int data;       //当没有缓冲数组的时候，用data接受的是char类型，自动转换为int类型--------当有缓冲数组时int返回的数组长度
        while((data=fileReader.read(buff))!=-1){//readLine方法读一行数据
        String str = new String(buff,0,data);
            System.out.println(str);
            fileWriter.write(buff);
        }
        fileReader.close();
        fileWriter.close();



    }
}
