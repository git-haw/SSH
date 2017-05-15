package top.haw358.demo.dao;

import top.haw358.demo.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public boolean isExists(String username);
}