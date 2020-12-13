package day01_code.data工具包;

import java.io.FileReader;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private  static String url;
    private  static String user;
    private  static String password;
    private static String driver;

    static {
        //读取资源，获取值
        try {
            //1.创建Properties集合类对象
            Properties pro = new Properties();
            //2.加载文件
            /*
             */
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            pro.load(new FileReader(path));
            //3.获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getconnection() throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }
    public static void close(Statement stmt,Connection conn){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    public static void close(Statement stmt, Connection conn, ResultSet rs){
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
