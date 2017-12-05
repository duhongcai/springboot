package com.qtec.studyboot.customer.dao;

import java.util.List;

/**
 * Created by duhc on 2017/10/30.
 */
public interface BaseDao<T> {
    /**
     * 通用增加
     *
     * @param t
     * @return
     */
    int insert(T t);

    int batchInsert(List<T> batch);

    /**
     * 通用查询
     *
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 通用查询 根据名字查询一个对象
     * @param name
     * @return
     */
    T findByName(String name);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    int deletOneById(int id);

    /**
     * 更新
     *       有问题 两个参数 mybatis不支持
     * @param id
     * @param t
     * @return
     */
    int updateById(int id, T t);
}
