package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.code.pojo.Characteristic;
import com.code.pojo.Epic;
import com.code.mapper.EpicMapper;
import com.code.service.EpicService;
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
public class EpicServiceImpl extends ServiceImpl<EpicMapper, Epic> implements EpicService {

    @Override
    public Boolean createEpic(Epic epic) {
        return this.save(epic);


    }

    @Override
    public List<Epic> getEpicByPid(int pid) {

        LambdaQueryWrapper<Epic> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Epic::getProjectId,pid);
        return this.list(lambdaQueryWrapper);
    }

    @Override
    public Boolean updateEpic(Epic epic) {
        return this.updateById(epic);
    }
}
