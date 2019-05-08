package com.ums.service.impl;

import com.ums.dao.UserDao;
import com.ums.dao.impl.UserDaoImpl;
import com.ums.domain.PageBean;
import com.ums.domain.User;
import com.ums.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * 用户管理功能实现
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public void addUser(User user) {
        dao.add( user );
    }

    @Override
    public void deleteUser(String id) {
        dao.delete( Integer.parseInt( id ) );
    }

    @Override
    public User findUserById(String id) {
        return dao.findById( Integer.parseInt( id ) );
    }

    @Override
    public void updateUser(User user) {
        dao.update( user );
    }

    @Override
    public void delSelectedUser(String[] ids) {
        //如果没有id被选中，不执行
        if (ids != null && ids.length > 0) {
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete( Integer.parseInt( id ) );
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt( _currentPage );
        int rows = Integer.parseInt( _rows );

        //当用户在第一页点击上一页时，赋值为1
        if (currentPage <= 0) {
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();

        //2.设置参数
        pb.setCurrentPage( currentPage );//当前页码
        pb.setRows( rows );//页面显示条数

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount( condition );
        pb.setTotalCount( totalCount );

        //4.调用dao查询list集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage( start, rows, condition );
        pb.setList( list );

        //5.计算总页码
        int totalPage = (totalCount % rows == 0) ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage( totalPage );
        return pb;
    }
}
