package top.haw358.demo.util.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import top.haw358.demo.util.GenericsUtils;
import top.haw358.demo.util.dao.BaseDao;

import java.io.Serializable;

/**
 * Created by haw on 17-7-20.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());


    public void save(T t) {
        getHibernateTemplate().save(t);
    }

    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }

    public T get(Serializable id) {
        return getHibernateTemplate().get(this.getEntityClass(), id);
    }

    public T load(Serializable id) {
        return getHibernateTemplate().load(this.getEntityClass(), id);
    }

    protected Class<T> getEntityClass() {
        return this.entityClass;
    }

    @Autowired
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
