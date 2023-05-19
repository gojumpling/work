package com.code.service;

import com.code.pojo.Team;
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
public interface TeamService extends IService<Team> {

    /**
     * 给团队添加成员，返回Boolean
     * @param team
     * @return
     */
    boolean addMembers(Team team);


    /**
     * 由用户ID，获取到项目ID列表
     * @param uid
     * @return
     */
    List<Integer> getProjectID(int uid);


    /**
     * 由项目ID，获取到用户ID列表
     * @param pid
     * @return
     */
    List<Integer> getUserID(int pid);


    Boolean changeType(Team team);

}
