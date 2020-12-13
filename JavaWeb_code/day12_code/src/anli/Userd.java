package anli;

import JDBC.JDBCUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Userd {
   private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());
    public User loguser(User user){
       try{ String sql="select *from user where username=? and password=?";
        User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword());
        return user1;
       }
       catch (Exception e){
           return null;
       }
    }
}
