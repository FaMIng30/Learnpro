package DataStructre;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

public class StaticTest {
   //java类加载执行的步骤：加载-->连接-->初始化
    //静态代码快在连接时执行1次且只执行一次，存于常量池中
    //非静态代码块在构造方法执行前执行一次每次访问时都会执行一次
    static {
        System.out.print("A");
    }
    public StaticTest(){
        System.out.print("a");
    }
    {
        System.out.print("C");
    }

    public static void sleep(){
        System.out.println("i am sleep");
    }


}
class B extends StaticTest {
    {
        System.out.print("D");
    }

    static{
        System.out.print("B");
    }

    public B (){
        System.out.print("b");
    }

    public static void main (String[] args){
        StaticTest st = new B();
        st = new B();

    }
}



