package day01_code.druid;

import day01_code.data工具包.JDBCUtils03;

import java.sql.Connection;
import java.sql.PreparedStatement;


/*
使用jdbcutils工具类
 */
public class DruidDemo02 {
    public static void main(String[] args) throws Exception {

        Connection conn = JDBCUtils03.getConnection();
        String sql = "insert into user values (null,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,"无误");
        pstmt.setDouble(2,782);
        int i = pstmt.executeUpdate();
        JDBCUtils03.close(pstmt, conn);

    }
}
