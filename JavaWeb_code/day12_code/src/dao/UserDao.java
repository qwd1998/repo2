package dao;

import JDBC.JDBCUtil;
import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/*
       操作数据库中User表的类
 */
public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtil.getDataSource());

    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ? ";
            User user =  template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
