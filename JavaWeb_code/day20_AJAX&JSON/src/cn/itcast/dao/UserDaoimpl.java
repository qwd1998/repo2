package cn.itcast.dao;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoimpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查找username是否被注册
     * @param user
     * @return
     */
    @Override
    public User chazhao(User user) {
     try {
         String sql = "select *from user where username = ? ";
         User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername());
         return user1;
     }catch (Exception e){
         return  null;
     }
    }
}
