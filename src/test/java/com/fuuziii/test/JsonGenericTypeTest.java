package com.fuuziii.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.cetiti.user.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yinlei
 * @since 2017/10/10 9:46
 */
public class JsonGenericTypeTest {

    @Test
    public void test1() {
        Bean<User> bean = new Bean<>();
        User user = new User();
        user.setAccount("yinlei");
        user.setTokenId("tokenId");
        bean.setObj(user);
        List<Bean<User>> list = new ArrayList<>();
        list.add(bean);

        JsonBean<List<Bean<User>>> jsonBean = new JsonBean<>();
        jsonBean.setData(list);

        String json = JSON.toJSONString(list);

        System.out.println(json);

        List<Bean<User>> refBean = JSON.parseObject(json, new TypeReference<List<Bean<User>>>(){});
        System.out.println(refBean);

        String json2 = JSON.toJSONString(jsonBean);
        JsonBean jsonBean1 = JSON.parseObject(json2, new TypeReference<JsonBean<List<Bean<User>>>>(){});
        System.out.println(jsonBean1);
    }
}
