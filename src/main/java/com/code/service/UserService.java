package com.code.service;

import com.code.pojo.Team;
import com.code.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
public interface UserService extends IService<User> {

    /**
     * 由用户ID，获取到用户列表
     * @param list
     * @return
     */
    List<User> getUser(List<Integer> list);

}
