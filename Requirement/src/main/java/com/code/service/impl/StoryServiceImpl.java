package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.code.pojo.Sprint;
import com.code.pojo.Story;
import com.code.mapper.StoryMapper;
import com.code.service.StoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.boot.autoconfigure.session.StoreType;
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
public class StoryServiceImpl extends ServiceImpl<StoryMapper, Story> implements StoryService {

    @Override
    public Boolean createStory(Story story) {
        return this.save(story);

    }

    @Override
    public Boolean updateStory(Story story) {
        return this.updateById(story);
    }

    @Override
    public List<Story> getStoryByCid(int cid) {
        LambdaQueryWrapper<Story> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Story::getCharacteristicId,cid);
        return this.list(lambdaQueryWrapper);
    }




}
