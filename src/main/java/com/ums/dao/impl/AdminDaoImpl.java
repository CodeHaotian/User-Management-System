package com.ums.dao.impl;

import com.ums.dao.AdminDao;
import com.ums.domain.Admin;
import com.ums.util.DruidUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 管理数据操作类
 */
public class AdminDaoImpl implements AdminDao {
    private JdbcTemplate template = new JdbcTemplate( DruidUtils.getDataSource() );

    @Override
    public Admin findByAdminIdAndPassword(String username, String password) {
        try {
            //1.定义sql
            String sql = " select * from admin where username = ? and password = ? ";
            //2.执行sql查找需要的数据
            Admin admin = template.queryForObject( sql, new BeanPropertyRowMapper<Admin>( Admin.class ), username, password );
            //3.返回数据
            return admin;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;//异常返回空
        }
    }
}
