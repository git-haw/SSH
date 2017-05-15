package top.haw358.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import top.haw358.demo.dao.UserDao;
import top.haw358.demo.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haw on 17-5-15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        String hsql = "from User";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        userList = query.list();
        return userList;
    }

    public boolean isExists(String userName) {
        Query query = sessionFactory.openSession()
                .createQuery("from User u where u.userName= :userName").setParameter("userName", userName);
        System.out.print(query.list().size());
        return query.list().size() > 0;
    }
}
