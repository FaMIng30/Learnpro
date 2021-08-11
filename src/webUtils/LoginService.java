package webUtils;

import bean.User;
import bean.UserMsg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginService {
    /**
     * 用户名是否存在
     * false  存在
     * true  不存在
     * @param username
     * @return
     */
    public  static  Boolean  existUsername(String username) {
        if(username==null||username.isEmpty())
            return  false;
        Connection connection=null;
        try {
             connection= JDBCutils.getConnection();
             String sql="select username from users where username=?";
            return CRUD.scalaquery( sql,username)==null;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }

    return  null;
    }

    /**
     * 查询用户名密码是否正确
     * @param username
     * @param passwords
     * @return
     */
    public  static  User queryLogin(String username,String passwords) {
        Connection  connection=null;
        try {
            connection=JDBCutils.getConnection();
            String sql="select * from users where username=?and passwords=?";
             return (User) CRUD.querysingle(sql, User.class,username,passwords);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }
        return  null;
    }

    public  static  Boolean  existTellphone(String tellphone){
        if(tellphone==null||tellphone.isEmpty())
            return  false;
        Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            String sql="select * from usermsg where tellphone=?";
              return  CRUD.querysingle(sql, UserMsg.class,tellphone)==null;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }
        return null;
    }
public static Boolean  existOrnot(String username,String tellphone){
        return existUsername(username)&&existTellphone(tellphone);
}



    public  static  void  register(String username,String tellphone,String passwords,String gender,String logopath,String truename) {
                         Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            String userSql="insert into users (username,passwords,logopath)values(?,?,?)";
            String usermsgSql="insert into usermsg(truename,tellphone,gender)values(?,?,?)";
            connection.setAutoCommit(false);
            //这里的connection不相同所以这里并不是真的事务，是相互独立的。还是会存在可能1成功2失败的情况。用Threadlocal保证connection的唯一性
            CRUD.update(userSql,username,passwords,logopath);//1
            CRUD.update(usermsgSql,truename,tellphone,gender);//2
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }


    }
    }

