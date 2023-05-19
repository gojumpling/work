package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.code.pojo.Project;
import com.code.pojo.Sprint;
import com.code.mapper.SprintMapper;
import com.code.service.SprintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    public int createSprint(Sprint sprint) {
        this.save(sprint);
        LambdaQueryWrapper<Sprint> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Sprint::getSprintId);
        return this.getOne(lambdaQueryWrapper).getSprintId();
    }
}
