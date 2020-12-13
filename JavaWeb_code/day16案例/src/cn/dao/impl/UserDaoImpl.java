package cn.dao.impl;

import cn.dao.UserDao;
import cn.domain.PageBean;
import cn.domain.User;
import cn.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库...
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }

    @Override
    public User denglu(User user) {
        try {
            String sql = "select * from user where username=? and password=?";
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return user1;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findByid(int id) {
        String sql = "select * from user where id =?";
        return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void update(User user) {
        String sql = "update user set name= ?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义一个模板化的sql
        String sql = "select count(*)from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        //定义一个参数的集合
        List<Object> params = new ArrayList<>();

        //2.遍历map
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            String value = condition.get(key)[0];

            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //3.判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//?是条件的值
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(),Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select *from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        //定义一个参数的集合
        List<Object> params = new ArrayList<>();

        //2.遍历map
        Set<String> keys = condition.keySet();
        for (String key : keys) {
            String value = condition.get(key)[0];

            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //3.判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and " + key + " like ? ");
                params.add("%"+value+"%");//?是条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ? , ? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);

        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }


}

