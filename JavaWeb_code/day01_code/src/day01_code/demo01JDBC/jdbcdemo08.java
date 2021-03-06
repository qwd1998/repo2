package day01_code.demo01JDBC;

import day01_code.domain.Emp;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
定义一个方法，查询emp表的数据将其封装为对象，然后装载集合
*  */
public class jdbcdemo08 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs=null;
        List<Emp> list = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db2?serverTimezone=GMT%2B8", "root", "root");
            statement = conn.createStatement();
            String sql = "select *from emp";
            rs = statement.executeQuery(sql);
             list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double bonus = rs.getDouble("bonus");
                double salary = rs.getDouble("salary");
                int dept_id = rs.getInt("dept_id");

                Emp emp = new Emp(id, ename, job_id, mgr, joindate, bonus, salary, dept_id);
                list.add(emp);

            }
            for (Emp emp : list) {
                System.out.println(emp);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


    }
}
