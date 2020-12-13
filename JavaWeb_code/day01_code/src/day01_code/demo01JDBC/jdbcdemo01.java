package day01_code.demo01JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcdemo01 {
    public static void main(String[] args) throws Exception {
        /*1.导入驱动jar包
            复制mysql-connector-java-5.1.37-bin.jar到libs文件中
         */
        //2.注册驱动，mysql5以后的驱动jar包可以省略不写
        // Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接（sql）对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2?serverTimezone=GMT%2B8", "root", "root");
        //4.定义sql语句
        String sql = "update X set mu =20 where id=1";
        //5. 执行sql的对象，statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);//影响的行数
        //8.资源释放
        stmt.close();
        conn.close();


    }

}
