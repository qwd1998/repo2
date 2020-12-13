package day01_code.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcdemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=GMT%2B8", "root", "root");
            String sql = "update X set mu=50000 where id = 3";
            statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println(i);
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }
    }

}

