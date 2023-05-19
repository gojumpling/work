package com.code.service;

import com.code.pojo.Project;
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
public interface ProjectService extends IService<Project> {

    /**
     * 创建项目
     * @param project
     * @return 项目ID
     */
    int createProject(Project project);


    /**
     * 由项目ID列表，获取项目
     * @param list
     * @return List<Project>
     */
    List<Project> getProject(List<Integer> list);

}
