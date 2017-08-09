package top.haw358.demo.util.dao;

import java.io.Serializable;

/**
 * Created by haw on 17-7-20.
 */
public interface BaseDao<T> extends Serializable{
    void save(T t);
    void update(T t);
    void delete(T t);
    T get(Serializable id);
    T load(Serializable id);
}
