package top.haw358.demo.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import top.haw358.demo.dao.UserDao;
import top.haw358.demo.pojo.Role;
import top.haw358.demo.pojo.User;
import top.haw358.demo.util.dao.impl.BaseDaoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by haw on 17-5-15.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUser(String username) {
        String hsql = "from User u where u.name= :username";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql)
                .setParameter("username", username);
        User user = (User) query.uniqueResult();
        return user;
    }

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        String hsql = "from User";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        userList = query.list();
        return userList;
    }

    public boolean isExists(String username) {
        User user = getUser(username);
        return user != null;
    }

    public Set<Role> getRoles() {
        String hsql = "from User u where u.name= :username";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hsql);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userDetails.getUsername();
        userDetails.getAuthorities();
        return null;
    }
}
