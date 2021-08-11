package DataStructre;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.Callable;

public class ListTesy {
    public static void main (String[] args){
        ListTesy aa=new ll();
    }
    String basename = "base";

    public ListTesy (){
        printName();
    }

    public void printName (){
        System.out.println(basename+"父类");
    }


} class ll extends ListTesy{
    String nname="sub";

    public void  printName(){
        System.out.println(nname+"子类");
    }

}



    //    public static void main (String[] args){
////
////        ArraysLists as=new ArraysLists(10);
////        as.add("a");
////        as.add("b");
////        as.add("c");
////        as.add("d");
////        System.out.println(as.toString());
////        System.out.println(as.length());
////        as.remove("1");
////        System.out.println(as.get(3));
////        System.out.println(as.toString());
////
//
//
//    }
//    @Test
//    public void test (){
//        Linklists ls = new Linklists();
//        ls.add("2");//添加
//        ls.add("3");
//        ls.add("4");
//        ls.add("5");
//        Object[] s = ls.toArray(ls);//链表转数组
//        for (int i = 0; i < s.length; i++)
//            System.out.println(s[i]);
//        System.out.println(ls.size());//长度
//
//    }
//
//    @Test
//    public void test1 (){
//        Linklists ls = new Linklists();
//        ls.add("11");
//
//        ls.add(123);
//        ls.add("asdasd");
//        ls.add(12.0);
//
//        ls.remove(0);
//        System.out.println(ls.getNode(2).element);
//        System.out.println(ls.get(2));
//        System.out.println(ls.toArray(ls));
//        System.out.println(3 >> 1);
////        System.out.println(ls.set(0,123));
////        System.out.println(ls);
//    }
//
//    @Test
//    public void Test3 (){
//        Hashmaps mm = new Hashmaps();
//        Map asd=new HashMap();
////     for (Character i=1;i<200;i++)
////         System.out.println((char)i+""+i.hashCode()%16);
//
//
//         mm.put('Q',"asdasd");
//         mm.put('A',"wwwwwww");
//         mm.put(';',123123);
//         mm.put('+',44);
//         mm.put(']',"hahah");
//         mm.put('K',"wwwweeeee");
//         mm.put('[',"qqqqq");
//         mm.put('{',"eeeee");
//
//
////        System.out.println();
////        System.out.println(mm.get(1));
//        mm.remove('[');
//        System.out.println(mm.toString());
//
//
//    }
//    @Test
//    public void test4(){
//
//    }
//}