package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.code.pojo.Project;
import com.code.pojo.Sprint;
import com.code.mapper.SprintMapper;
import com.code.service.SprintService;
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
public class SprintServiceImpl extends ServiceImpl<SprintMapper, Sprint> implements SprintService {

    @Override
    public Boolean createSprint(Sprint sprint) {
        return this.save(sprint);

    }

    @Override
    public Boolean updateSprint(Sprint sprint) {
        return this.updateById(sprint);
    }

    @Override
    public List<Integer> getSprintID(int pid) {

        LambdaQueryWrapper<Sprint> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Sprint::getProjectId,pid);

        return this.list(lambdaQueryWrapper)
                .stream().map(Sprint::getSprintId).collect(Collectors.toList());
    }
}
