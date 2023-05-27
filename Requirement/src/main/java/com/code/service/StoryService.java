package com.code.service;

import com.code.pojo.Story;
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
public interface StoryService extends IService<Story> {

    Boolean createStory(Story story);

    Boolean updateStory(Story story);


    List<Story> getStoryByCid(int cid);

}
