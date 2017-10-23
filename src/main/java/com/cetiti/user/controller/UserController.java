package com.cetiti.user.controller;

import com.cetiti.base.bean.JsonBean;
import com.cetiti.user.model.User;
import com.cetiti.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 用户控制器，演示
 *
 * @author yinlei
 * @since 2017/9/30 10:43
 */
@Controller
@RequestMapping("/user") // 这个url的规则一般是 类名去掉controller后缀，然后驼峰命名
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/list") // url的一般规则是方法名，一般也是jsp文件的名字
    public String list() {
        if (LOGGER.isDebugEnabled()) { // 如果打印的日志很多，且比较耗性能，建议这样。
            LOGGER.debug("this is [{}] method.", "list"); // 使用占位符
        }
        return "user/list"; // 规则是`类url/方法url`
    }

    /**
     * demo return json data
     *
     * @param user 普通的表单参数
     * @return json data
     */
    @ResponseBody // 默认返回json格式数据，通过定制HttpMessageConverter可以返回其他格式数据，如：protobuf
    @RequestMapping("/json")
    public JsonBean json(User user) {
        JsonBean bean = new JsonBean();
        try {
            // 这里可以先对参数进行验证...

            List<User> userList = userService.queryList(user);
            bean.setData(userList);
        } catch (Exception e) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("json method error message=[{}].", e.getMessage());
                LOGGER.error("json method error.", e); // 打印整个异常堆栈，无需占位符
            }
            bean.setCode(-1);
            bean.setMessage("json method occur error.");
        }
        return bean;
    }

    /**
     * demo return json data
     *
     * @param user json 格式的参数
     * @return json data
     */
    @ResponseBody
    @RequestMapping("/json2")
    public JsonBean json2(@RequestBody User user) { // @RequestBody 默认接收json格式参数，通过定制可以接收其他格式参数，如protobuf
        JsonBean bean = new JsonBean();
        try {
            // 这里可以先对参数进行验证...

            List<User> userList = userService.queryList(user);
            bean.setData(userList);
        } catch (Exception e) {
            LOGGER.error("json2 method error message=[{}].", e.getMessage());

            bean.setCode(-1);
            bean.setMessage("json2 method occur error.");
        }
        return bean;
    }
}
