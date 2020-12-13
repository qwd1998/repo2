package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.UserDaoimpl;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

public class UserServicimpl implements UserService {
    private UserDao dao = new UserDaoimpl();
    @Override
    public User chazhao(User user) {
        return dao.chazhao(user);
    }
}
