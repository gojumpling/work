package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.mapper.WorkMapper;
import com.code.pojo.Work;
import com.code.service.WorkService;
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
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {

    @Override
    public int createWork(Work work) {
        this.save(work);
        LambdaQueryWrapper<Work> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.orderByDesc(Work::getWordId);
        return this.getOne(lambdaQueryWrapper).getWordId();
    }

    @Override
    public boolean finishWork(int wid) {
        LambdaQueryWrapper<Work> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Work::getWordId,wid);
        Work work = this.getOne(lambdaQueryWrapper);
        return this.saveOrUpdate(work);
    }


}
