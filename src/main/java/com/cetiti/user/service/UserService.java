package com.cetiti.user.service;

import com.cetiti.base.dao.BaseDao;
import com.cetiti.base.service.BaseService;
import com.cetiti.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service
 *
 * @author yinlei
 * @since 2017/10/9 10:51
 */
@Service
public class UserService extends BaseService<User, String> {

    @Override
    @Autowired // 参数名是对应的 DAO 类的驼峰命名法，如：UserDao->userDao
    public void setBaseDao(BaseDao<User, String> userDao) {
        this.baseDao = userDao;
    }
}
