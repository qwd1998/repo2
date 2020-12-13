package domain;

import JDBC.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
       JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
        /*String sql="select * from user";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }*/

        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = sc.nextLine();
        if(z(username,password)){
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }


    }
    public static boolean z(String username,String password){
        JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
        String sql = "select *from user where username=? and password=?";
        List<Map<String, Object>> maps = template.queryForList(sql, username, password);
        return maps!=null;
    }
}
