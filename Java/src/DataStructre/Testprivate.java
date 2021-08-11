package DataStructre;

import java.math.BigDecimal;

public class Testprivate {
    private int test1=3;
    private BigDecimal bigDecimal=new BigDecimal(3.4);
    private double test2;

    public double getTest2 (){
        return 3.55;
    }

    public void setTest2 (double test2){
        this.test2 = test2;
    }

    public int getTest1 (){
        return 5;
    }

    public void setTest1 (int test1){
        this.test1 = test1;
    }

    public BigDecimal getBigDecimal (){
        return new BigDecimal(5.5);
    }

    public void setBigDecimal (BigDecimal bigDecimal){
        this.bigDecimal = bigDecimal;
    }

    public static void main (String[] args){
        Testprivate tp=new Testprivate();
        System.out.println(tp.test1);
        System.out.println(tp.bigDecimal);
        System.out.println(tp.test2);
    }
}
