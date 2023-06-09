package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.code.pojo.Epic;
import com.code.pojo.Project;
import com.code.mapper.ProjectMapper;
import com.code.service.ProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Override
    public int createProject(Project project) {
        this.save(project);
        LambdaQueryWrapper<Project> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Project::getProjectId);

        return this.list(lambdaQueryWrapper).get(0).getProjectId();
    }

    @Override
    public List<Project> getProject(List<Integer> list) {


        LambdaQueryWrapper<Project> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        lambdaQueryWrapper.in(Project::getProjectId,list);

        return this.list(lambdaQueryWrapper);
    }

    @Override
    public Project getProjectById(int pid) {
        LambdaQueryWrapper<Project> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Project::getProjectId,pid);

        return this.getOne(lambdaQueryWrapper);
    }
}
