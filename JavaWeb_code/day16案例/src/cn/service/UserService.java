package cn.service;

import cn.domain.PageBean;
import cn.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<User> findAll();

    User denglu(User user);

    void add(User user);

    void delete(int id);

    User findUserByid(String id);

    void update(User user);

    void deleteId(String[] uids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

}
