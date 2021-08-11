package IOtest;

import java.io.*;

public class IOutils {
    //流的关闭
    public static void ioClose (Closeable... params){//可变参，因为InputStream/OutputStream都继承Closeable接口所以定义一个Closeable类型的接口
        for (int i = 0; i < params.length; i++) {//foreach循环和普通for循环的区别：foreach（int b: list）是将list中的数赋值个b在操作，操作的是b并不是list里面的值
            //for循环是对里面的值做操作。所以这里用普通for循环
            if (params[i] != null) {
                try {
                    params[i].close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //复制文件
    public static void copy (File srcfile, File desfile){
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            //获得字节流
            inputStream = new BufferedInputStream(new FileInputStream(srcfile));
            outputStream = new BufferedOutputStream(new FileOutputStream(desfile));
            //建立缓冲区
            byte[] buff = new byte[1024];
            int len;//字节长度
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff);
                outputStream.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ioClose(inputStream, outputStream);
        }
    }


    //File.delete方法使用的时候需要先关闭引用了该文件的流，在执行删除，否则无法删除
    //对文件的小加密
    //1.先将文件存入字节数组流的缓冲区中
    //2.再由输出流输出字节数组流中的数据，存入文件中
    public static void secret (File Filepath){
        //造流
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ByteArrayOutputStream bos=null;
        //文件后缀名
        String lastname = Filepath.getName().substring(Filepath.getName().indexOf("."), Filepath.getName().length());

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(Filepath));
             bos= new ByteArrayOutputStream();// 字节数组输出流不许要目标文件路径，是一个缓冲区。大小根据文件自动创建 。
                        // 字节数组流，将文件内容存入一个缓冲区，字节数组保留。在由输出流从缓冲区中读取，输出到文件中

            int data;
            while ((data = bufferedInputStream.read()) != -1) {
                  bos.write(data^5);           //文件是以字节的形式保存，字节是以二进制方式，所以二进制数对5异或改变它的二进制编码，再次异或5可以恢复
            }
            bufferedInputStream.close();
            Filepath.delete();
            //输出流在文件不存在时会自动创建文件夹，当输入流和输出流的文件名相同时会将源文件覆盖掉，一个空文件。在读取数据时没有数据可读。所以在下面定义输出流
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(Filepath));
            System.out.println(bos.toByteArray().length);
           bufferedOutputStream.write(bos.toByteArray());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOutils.ioClose(bufferedOutputStream,bos);

        }

    }

    //删除文件
    public static void delFile (File file){
        if (file.isDirectory()) {
            File[] list = file.listFiles();
            for (int i = 0; i < list.length; i++) {
                delFile(list[i]);
            }
        }
        file.delete();//无论if结果都会执行

    }
//计算文件夹的大小
    public static long dirLength(File file){

        if (file.isFile()){
           return file.length();
        }else{
            Long count=0l;
            File [] list=file.listFiles();
            for (int i = 0; i < list.length; i++) {
               count+= dirLength(list[i]);
                }
            return count;

        }



    }

    //遍历文件夹下的文件
//    public static void countFile (File file){
//        if (!file.exists()) {
//            return;
//        }
//
//        System.out.println(file.getName());
//        if (file.isDirectory()) {
//            String [] list = file.list();
//            for (int i = 0; i < list.length; i++) {
//                System.out.println(list[0]);
//            }
//
//        }
//    }
//}
}
