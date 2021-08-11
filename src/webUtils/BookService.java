package webUtils;

import bean.Page;
import bean.book;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class BookService {
    public static List<book> queryBook (){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "select * from book";
            return CRUD.queryList(sql, book.class);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
        return null;
    }






    public static int deletes (int id){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "delete from book where ID=?";
            return CRUD.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
        return -1;
    }

    public static int updateb (int id, String name, String author, String descrip){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "update book set name=?,author=?,descrip=? where ID=?";
            return CRUD.update(sql, name, author, descrip, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
        return -1;
    }

    public static book queryByid (int id){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "select * from book where ID=?";
            return CRUD.querysingle(sql, book.class, id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
        return null;
    }

    public static void add (String name, String author, String descrip){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "insert into book(name,author,descrip)values(?,?,?)";
            CRUD.update(sql, name, author, descrip);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
    }
//
    public static int pageCounts (){
        Connection connection = null;
        try {
            connection = JDBCutils.getConnection();
            String sql = "select count(*) from book";
            Number count=(Number) CRUD.scalaquery(sql);
            return count.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
        return -1;
    }
    public static List<book> pageList(int pageNo,int pageSize){
        Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            int begin=(pageNo-1)*pageSize;
            String sql="select * from book limit ?,?";
          return   CRUD.queryList(sql,book.class,begin,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.close(connection, null, null);
        }
          return null;
    }


    public static Page<book> searchbyname(String name,int pageNo,int pageSize){
        String sname="%"+name+"%";
        String sql="select * from book where author like ? or name like ?";
          List<book> list=   CRUD.queryList(sql,book.class,sname,sname);
          Page page=new Page();
          int pageCounts=list.size();
          int pageTotal=pageCounts/pageSize;
        if (pageCounts()%pageSize>0)
            pageTotal+=1;
        page.setPagecount(pageCounts);
        page.setPageTotal(pageTotal);
        page.setPagesize(pageSize);
        page.setPageitem(list);

        return page;


    }

    public static Page<book> page(int pageNo,int pageSize){
        System.out.println(Thread.currentThread().getName());
        Page page=new Page();
        //总页数
        int pageTotal=pageCounts()/pageSize;
        if (pageCounts()%pageSize>0)
            pageTotal+=1;
        page.setPageTotal(pageTotal);
        //当前页码
        page.setPageNo(pageNo);
        //显示数目
        page.setPagesize(pageSize);
        //总记录数
        page.setPagecount(pageCounts());
        //商品信息
       List<book> bookList= pageList(page.getPageNo(),pageSize);
       page.setPageitem(bookList);
     return page;
    }
}

