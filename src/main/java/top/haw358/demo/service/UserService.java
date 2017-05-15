package top.haw358.demo.service;

import top.haw358.demo.pojo.User;

import java.util.List;

/**
 * Created by haw on 17-5-14.
 */
public interface UserService {

    public List<User> getAllUser();

    public boolean isExists(String username);
}
