package top.haw358.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.haw358.demo.dao.UserDao;
import top.haw358.demo.pojo.User;
import top.haw358.demo.service.UserService;

import java.util.List;


/**
 * Created by haw on 17-5-14.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Cacheable(cacheNames = "isExists", key = "#username")
    public boolean isExists(String username) {
        return userDao.isExists(username);
    }
}
