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
    boolean insert(T t);

    boolean batchInsert(List<T> batch);

    /**
     * 通用查询
     *
     * @param id
     * @return
     */
    T findOne(int id);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deletOneById(int id);

    /**
     * 更新
     *
     * @param id
     * @param t
     * @return
     */
    boolean updateById(int id, T t);
}
