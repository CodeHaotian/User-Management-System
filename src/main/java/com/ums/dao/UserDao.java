package com.ums.dao;

import com.ums.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {

    /**
     * 添加数据接口
     * @param user
     */
    void add(User user);

    /**
     * 根据id删除数据
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查询接口
     * @param id
     * @return
     */
    User findById(int id);

    /**
     * 根据id修改数据
     * @param user
     */
    void update(User user);

    /**
     * 查询总记录数
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
