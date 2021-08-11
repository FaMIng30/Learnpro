package webUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
  static  QueryRunner queryRunner=new QueryRunner();

/*
对数据库的插入、删除、更新
返回受影响的行数
 */
    public static  int  update(String SQL,Object...params) {
        Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            int update =queryRunner.update(connection,SQL,params);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }
        return 0;
    }


    /**
     * 该方法用于查询单行数据，并把它封装成对象返回
     * new BeanHandle 单行/对象的控制器
     * @param SQL   sql语句
     * @param clazz   javabean类名
     * @param params   preparestatement中占位符的参数，为不定参数
     * @param <T>    返回的类型
     * @return  返回一个Javabean对象
     */
    public static <T> T querysingle(String SQL,Class<T> clazz,Object...params){
        Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            return  queryRunner.query(connection,SQL,new BeanHandler<T>(clazz),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }
       return null;
    }

    /**
     * 该方法用于查询多行记录
     * new BeanListHandler 是多行的控制器
     * @param SQL   sql语句
     * @param clazz  javabean类名
     * @param params preparestatement中占位符的参数，为不定参数
     * @param <T>  返回的类型
     * @return     装有javabean对象的list 集合
     */
    public  static<T> List<T>  queryList(String SQL,Class<T>clazz,Object...params){
        Connection connection=null;
        System.out.println(Thread.currentThread().getName());
    try {
        connection=JDBCutils.getConnection();
        List<T> list=new ArrayList<>();
        list=queryRunner.query(connection,SQL,new BeanListHandler<T>(clazz),params);
        return list;
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
            JDBCutils.close(connection,null,null);}
    return null;
    }

    /**
     *
     * @param sql  sql语句
     * @param params  preparestatement中占位符的参数，为不定参数
     * @return  一个值
     */
    public static Object scalaquery(String sql,Object...params){
        Connection connection=null;
        try {
            connection=JDBCutils.getConnection();
            return queryRunner.query(connection,sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutils.close(connection,null,null);
        }
        return  null;
    }
}
