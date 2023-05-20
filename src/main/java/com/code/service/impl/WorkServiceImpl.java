package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.mapper.WorkMapper;
import com.code.pojo.Work;
import com.code.service.WorkService;
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
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {

    @Override
    public Boolean createWork(Work work) {
        return this.save(work);

    }

    @Override
    public Boolean updateWork(Work work) {
        return this.updateById(work);
    }



    @Override
    public List<Work> getWork(List<Integer> list) {

        LambdaQueryWrapper<Work> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(Work::getSprintId,list);

        return this.list(lambdaQueryWrapper);

    }


}
