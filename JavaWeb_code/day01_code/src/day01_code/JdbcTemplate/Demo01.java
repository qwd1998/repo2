package day01_code.JdbcTemplate;

import day01_code.data工具包.JDBCUtils03;
import org.springframework.jdbc.core.JdbcTemplate;

public class Demo01 {
    public static void main(String[] args) {
        //2.创建CdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils03.getDataSours());
        //3.调用方法
        String sql = "update user set password =500 where id=?";
        int i = template.update(sql, 7);
        System.out.println(i);


    }
}
