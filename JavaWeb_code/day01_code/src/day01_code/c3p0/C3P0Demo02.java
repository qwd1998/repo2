package day01_code.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo02 {
    public static void main(String[] args) throws SQLException {
        DataSource ds = new ComboPooledDataSource();//无参
        DataSource ds1 = new ComboPooledDataSource("otherc3p0");//有参
        for (int i = 0; i < 11; i++) {
            Connection con = ds.getConnection();
            System.out.println(i);
            if(i==5){
                con.close();//归还到连接池
            }
        }
        for (int i = 0; i < 10; i++) {
            Connection con = ds1.getConnection();
            System.out.println(i);
            /*if(i==5){
                con.close();//归还到连接池
            }*/
        }


    }
}
