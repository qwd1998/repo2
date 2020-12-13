package anli;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Userd {
   private JdbcTemplate jdbcTemplatee = new JdbcTemplate(JDBCUtil.getDataSource());
    public User loguser(User user) {
        try {
            String sql = "select *from user where username=? and password=?";
            User user1 = jdbcTemplatee.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return user1;
        } catch (Exception e) {
            return null;
        }
    }
}
