package day01_code.druid;

import day01_code.data工具包.JDBCUtils03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*
使用jdbcutils工具类
 */
public class DruidDemo03 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JDBCUtils03.getConnection();
            String sql = "update  user set password = ? where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,5);
            ps.setInt(2,7);
            int i = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            JDBCUtils03.close(ps, con);

        }


    }
}
