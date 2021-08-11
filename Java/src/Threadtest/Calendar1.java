package Threadtest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calendar1 {
    public static void main (String[] args) throws ParseException{
//       Breads B=new Breads();
//
//      new Thread(new Breads.Producer(B)).start();
//      new Thread(new Breads.Custom(B)).start();


//        Date date= new Date();
//        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date2=df.format(date);
//        String date3="2021-03-24 21:04:27 星期三 第158天";

//        System.out.println(date2);
//        System.out.println(df.parse(date3));

        System.out.println("请输入如期\t格式：2020-10-10");
        Scanner sc=new Scanner(System.in);
        String date=sc.next();
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=dateFormat.parse(date);//字符串转日期
        Calendar calendar=new GregorianCalendar();
        calendar.setTime(date1);//日期转日历
        System.out.println("日\t一\t二\t三\t四\t五\t六");
         int days=calendar.getActualMaximum(calendar.DATE);//日期的最大天数
         int day=calendar.get(calendar.DAY_OF_MONTH);//该月的几号
        calendar.set(calendar.DAY_OF_MONTH,1);//将日期设为1号,循环遍历
        for (int i=0;i<calendar.get(calendar.DAY_OF_WEEK)-1;i++){//输入日期天数对应的星期打印空格，时号数与星期匹配
                                                                  //星期为1-7，1为星期日，7为星期六
            System.out.print("\t");
        }

        for(int i=1;i<=days;i++){//循环该月的最大天数此
            if (day==calendar.get(calendar.DAY_OF_MONTH)){//当日期的等于输入的日期加*标记
            System.out.print(calendar.get(calendar.DAY_OF_MONTH)+"*\t");
            }else{
                System.out.print(calendar.get(calendar.DAY_OF_MONTH)+"\t");
            }

            if (calendar.get(calendar.DAY_OF_WEEK)==calendar.SATURDAY)//当日期星期六时换行
                System.out.println();

            calendar.add(calendar.DAY_OF_MONTH,1);//日期加一天

        }

    }
}
