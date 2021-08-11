package IOtest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

    import java.io.File;
    import java.io.IOException;

public class Filess {

//File类 ：把文件作为一个对象。对文件的操作
// 1.file对象可以是文件也可以是文件夹
//2.如果没有file的文件，file对象输出的值是默认值，只存在内存中，并没有实际的操作
 //3.File的delete 方法只能删除文件以及里面没有任何东西的目录，如果文件夹中还有其他文件或文件夹，则需要先删除文件和文件夹
public static void main (String[] args) throws IOException{
//        File file1 =new File("Java/resource/1.jpg");//main方法中的相对路径相对的是项目即Learnpro，测试中的相对路径相对的是Module
    File file1= new File("Java/resource","1.jpg");//第一个参数为上层文件，后一个参数为子文件
    File file2 = new File("D:\\JAVA\\io1\\hello.jpg");
    File file3 = new File("D:\\BaiduNetdiskDownload\\尚硅谷图解Java设计模式");
    System.out.println("file1文件名为"+file1.getName());//文件名
    System.out.println("file2文件名为"+file2.getName());
    System.out.println("file1文件大小为"+file1.length());//文件大小
    System.out.println("file2文件大小为"+file2.length());
    System.out.println("file1的绝对路径"+file1.getAbsolutePath());//绝对路径
    System.out.println("file2的绝对路径"+file2.getAbsolutePath());
    System.out.println("file1的上层目录为"+file1.getParent());//上层目录
    System.out.println("file2的上层目录为"+file2.getParent());
    System.out.println("file1是否存在"+file1.exists());
    System.out.println("file2是否存在"+file2.exists());
    System.out.println("file1是否删除"+file1.delete());
    System.out.println(file2.createNewFile());//创建一个空文件 如果是图片 视频等则是大小是大小为0不可打开文件
    System.out.println(file1.mkdir());//创建一个文件夹，如果文件夹上层目录不存在的或则不创建
    System.out.println(file1.mkdirs());//如果文件夹的路径的上层目录不存在时，会帮忙一起创建上层文件夹
    for (String i:file3.list())
    System.out.println(i);//返回该文件下的文件名  以String数组类型返回
    System.out.println();
    System.out.println(file3.listFiles());//返回该文件下的文件名  以file对象类型返回


}
}
