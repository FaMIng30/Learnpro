package webUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mysql.cj.protocol.Resultset;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCutils {
    static DataSource dataSource;
   static Properties properties;
   /*
      加载配置文件 建立数据库连接池
    */
    static{
       properties=new Properties();
        try {
            properties.load(new FileInputStream("C:\\Users\\Tomorrow\\eclipse-workspace\\Learnpro\\web\\lib\\druid"));
           dataSource= DruidDataSourceFactory.createDataSource(properties);//创建连接池
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //从连接池获得连接
    public static Connection  getConnection() throws SQLException{
        return dataSource.getConnection();
    }

    /**
     * 关闭连接
     * Statement 参数也可以写preparestatement参数
     * 因为preparestatement是继承Statement的
     * 多态性
     */
    public static void close(Connection connection, Statement statement, ResultSet resultset) {
          if(connection!=null){
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
              if (statement!=null){
                  try {
                      statement.close();
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
                  if(resultset!=null){
                      try {
                          resultset.close();
                      } catch (SQLException e) {
                          e.printStackTrace();
                      }
                  }
              }
          }
    }
    public static int parseInt (String value, int defaultvalue){
        if (value == null || value.length() == 0) {
            return defaultvalue;
        } else {
            int i = Integer.parseInt(value);
            return i;
        }
    }
}
