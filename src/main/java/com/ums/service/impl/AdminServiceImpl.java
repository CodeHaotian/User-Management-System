package com.ums.service.impl;

import com.ums.dao.AdminDao;
import com.ums.dao.impl.AdminDaoImpl;
import com.ums.domain.Admin;
import com.ums.service.AdminService;

/**
 * 管理员功能实现
 */
public class AdminServiceImpl implements AdminService {
    private AdminDao dao = new AdminDaoImpl();

    @Override
    public Admin login(Admin admin) {
        return dao.findByAdminIdAndPassword( admin.getUsername(), admin.getPassword() );
    }
}
