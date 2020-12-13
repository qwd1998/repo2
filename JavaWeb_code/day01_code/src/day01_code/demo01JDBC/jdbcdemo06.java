package day01_code.demo01JDBC;

import java.sql.*;

/*
执行DDL语句
 */
public class jdbcdemo06 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=GMT%2B8", "root", "root");
            String sql = "select *from x";
            statement = conn.createStatement();
            //执行sql
            /*ResultSet*/
            resultSet = statement.executeQuery(sql);
            //6.1让游标向下移动一行
            while (resultSet.next()) {  //判断是否有数据，如果resultSet.next()返回为false，则是最后一行的下一行
                //6.2获取数据
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                double aDouble = resultSet.getDouble(2);
                System.out.println(id + " " + name + " " + aDouble);
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
                if (resultSet != null) {
                    try {
                        resultSet.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        }
    }

}

