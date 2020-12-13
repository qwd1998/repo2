package day01_code.demo01JDBC;

import day01_code.data工具包.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/*
需求：1.通过键盘输入用户名和密码
     2.判断用户是否登录成功
 */
public class jdbcdemo09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String sc1 = sc.nextLine();
        System.out.println("请输入用户名密码");
        String sc2= sc.nextLine();
        boolean login = new jdbcdemo09().login(sc1, sc2);
        if(login){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登陆失败");
        }
    }

    public boolean login(String username, String password) {
        if ((username == null) || (password == null)) {
            return false;
        }
        Connection conn = null;
      //  Statement stmt = null;
        PreparedStatement pstmt= null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getconnection();
            //String sql = "select *from user where username='"+username+"' AND password= '"+password+" '";
            String sql = "select *from user where username=? AND password= ?";
            //stmt = conn.createStatement();
             pstmt = conn.prepareStatement(sql);

             pstmt.setString(1,username);
             pstmt.setString(2,password);
           // resultSet = stmt.executeQuery(sql);
            resultSet = pstmt.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt, conn, resultSet);
        }
        return false;
    }
}
