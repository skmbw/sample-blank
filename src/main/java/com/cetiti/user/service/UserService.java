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
// 默认的事务管理器名字是transactionManager，否则自己指定。
// 隔离级别是DB的默认隔离级别，可设置
// 事务传播是Required，可设置
// 事务超时，默认是数据库的超时时间，可设置
// 默认对运行时异常回滚，可设置
// 默认readonly=false，非只读事务
//@Transactional
public class UserService extends BaseService<User, String> {

    @Override
    @Autowired // 参数名是对应的 DAO 类的驼峰命名法，如：UserDao->userDao
    public void setBaseDao(BaseDao<User, String> userDao) {
        this.baseDao = userDao;
    }
}
