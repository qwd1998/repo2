package cn.service.impl;

import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.domain.PageBean;
import cn.domain.User;
import cn.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User denglu(User user) {
        return dao.denglu(user);
    }

    @Override
    public void add(User user) {
         dao.add(user);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public User findUserByid(String id) {
        return dao.findByid(Integer.parseInt(id));
    }

    @Override
    public void update(User user) {
         dao.update(user);
    }

    @Override
    public void deleteId(String[] uids) {
        if(uids!=null && uids.length>0){
            for (String uid : uids) {
                dao.delete(Integer.parseInt(uid));
            }

        }
    }

    @Override
    public PageBean<User> findUserByPage(String s_currentPage, String s_rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(s_currentPage);
        int rows = Integer.parseInt(s_rows);
        if(currentPage <= 0){
            currentPage=1;
        }

        //创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //调用DAO查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用DAO查询List集合
        int start = (currentPage-1)*rows;
        List<User> list =  dao.findByPage(start,rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = totalCount % rows == 0 ? totalCount/rows :(totalCount/rows)+1;

       if(currentPage >= totalPage){
            currentPage=totalPage;
        }
        pb.setCurrentPage(currentPage);
        pb.setTotalPage(totalPage);
        return pb;
    }


}
