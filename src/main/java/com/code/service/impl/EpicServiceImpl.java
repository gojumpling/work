package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.code.pojo.Characteristic;
import com.code.pojo.Epic;
import com.code.mapper.EpicMapper;
import com.code.service.EpicService;
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
public class EpicServiceImpl extends ServiceImpl<EpicMapper, Epic> implements EpicService {

    @Override
    public Boolean createEpic(Epic epic) {
        return this.save(epic);

//        LambdaQueryWrapper<Epic> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        lambdaQueryWrapper.orderByDesc(Epic::getEpicId);
//        return this.getOne(lambdaQueryWrapper).getEpicId();
    }
}
