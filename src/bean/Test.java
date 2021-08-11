package bean;

import webUtils.CRUD;

import java.sql.ClientInfoStatus;
import java.util.List;

public class Test {
    public static void main (String[] args){
        String sql="insert into book(ID,name,author,descrip)values(?,?,?,?) ";
        CRUD.update(sql,666,"小明奇遇记","小明","很好看");
        String sql2="select * from book where name=?";
       book b= CRUD.querysingle(sql2,book.class,"小明奇遇记");
           System.out.println(b.toString());

       }
    }

