package top.haw358.demo.dao;

import top.haw358.demo.pojo.Role;
import top.haw358.demo.pojo.User;
import top.haw358.demo.util.dao.BaseDao;

import java.util.List;
import java.util.Set;

public interface UserDao extends BaseDao<User> {
    public User getUser(String username);

    public List<User> getAllUser();

    public boolean isExists(String username);

}