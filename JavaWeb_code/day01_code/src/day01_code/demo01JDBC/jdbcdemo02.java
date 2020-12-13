package day01_code.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1.添加一条记录
 * 2.修改一条记录
 * 3.删除一掉记录
 *
 * */
public class jdbcdemo02 {
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "insert into X values(null,3000)";
            /* Connection*/
            conn = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=GMT%2B8", "root", "root");
            /* Statement*/
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
            System.out.println(i);
            conn.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

}
