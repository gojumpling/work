package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.code.pojo.Project;
import com.code.pojo.Team;
import com.code.mapper.TeamMapper;
import com.code.service.TeamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

    @Override
    public boolean addMembers(Team team) {
        return this.save(team);
    }

    @Override
    public List<Integer> getProjectID(int uid) {

        LambdaQueryWrapper<Team> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Team::getUserId,uid);

        return this.list(lambdaQueryWrapper)
                .stream().map(Team::getProjectId).collect(Collectors.toList());
    }


    public List<Integer> getUserID(int pid) {
        LambdaQueryWrapper<Team> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Team::getProjectId,pid);

        return this.list(lambdaQueryWrapper)
                .stream().map(Team::getUserId).collect(Collectors.toList());

    }

    @Override
    public Boolean changeType(Team team) {

        LambdaUpdateWrapper<Team> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(Team::getUserId,team.getUserId()).set(Team::getType,team.getType());



//        lambdaUpdateWrapper.eq(Team::getProjectId,team.getProjectId());
//        lambdaUpdateWrapper.eq(Team::getType,team.getType());

        return this.update(lambdaUpdateWrapper);

    }


}
