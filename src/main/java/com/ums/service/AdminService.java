package com.ums.service;

import com.ums.domain.Admin;

/**
 * 管理员的业务接口
 */
public interface AdminService {

    /**
     * 管理员登录方法
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
