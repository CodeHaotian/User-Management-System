package com.ums.dao;

import com.ums.domain.Admin;

/**
 * 管理员操作Dao
 */
public interface AdminDao {
    /**
     * 登录接口
     * @param username 管理账号
     * @param password 管理密码
     * @return
     */
    Admin findByAdminIdAndPassword(String username, String password);
}
