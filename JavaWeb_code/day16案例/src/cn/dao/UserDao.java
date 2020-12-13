package cn.dao;

import cn.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {


    public List<User> findAll();
    public User denglu(User user);
    public void add(User user );
    public void delete(int id);
    User findByid(int id);

    void update(User user);

    /**
     *   查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 查询每页记录
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
