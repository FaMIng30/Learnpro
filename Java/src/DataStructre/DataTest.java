package DataStructre;

import org.junit.Test;

import java.util.Stack;

public class DataTest {
    @Test
    public void singlelingk(){
        SingleLink sl=new SingleLink();
        sl.add(23);
        sl.add(33);
        sl.add(43);
        sl.add(53);
        sl.add(63);
        System.out.println(sl.get());
        System.out.println(sl.get());
        System.out.println(sl.get());
        System.out.println(sl.get());
        System.out.println(sl.get());
        System.out.println(sl.get());

        System.out.println(sl.toString());
    }

    @Test
    public void Sequence(){
        Sequense se= new Sequense();
        se.add(2);
        se.add(3);
        se.add(4);
        se.add(5);
        se.add(6);
//        se.print();
        System.out.println("-----------------------");

        se.get();
        se.get();
        se.get();
//        se.print();
        System.out.println("-----------------------");
        se.add(7);
        se.add(8);
        se.print();


    }


    @Test
    public void tree(){
        Treess<String> trees= new Treess<>();
        trees.setRoot(new TreeNode<String>(0,"String",null,null));
        TreeNode p1= new TreeNode(1,"String1",null,null);
        TreeNode p2=new TreeNode( 2,"String2",null,null);
        TreeNode p3=new TreeNode( 3,"String3",null,null);
        TreeNode p4=new TreeNode( 4,"String4",null,null);
        TreeNode p5=new TreeNode( 5,"String5",null,null);
        TreeNode p6=new TreeNode( 6,"String6",null,null);
        trees.root.setLeft(p1);
        trees.root.setRight(p2);
        p1.setLeft(p3);
        p1.setRight(p4);
        p2.setLeft(p5);
        p2.setRight(p6);
        trees.del(1);
      trees.afterOrder();
        System.out.println(trees.afterSearch(1));

    }

    @Test
    public void test(){
          String pa="logo";
          int i=2;
          if (i==1){
              pa="11";
          }else if(i==2) {
              pa="22";
          }else if (i==3){
              pa="33";
          }

        System.out.println(pa);
//        Integer a=1;
//        Integer a2=192;
//        int b=192;
//        Integer c = new Integer(1);
//        Integer c2 = new Integer(129);
//        System.out.println(a2==b);//true  自动装拆箱
//        System.out.println();
    }


    @Test
    public void teeest(){

    }



}
