package com.code.controller;


import com.code.pojo.Epic;
import com.code.pojo.Story;
import com.code.service.StoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@RestController
@RequestMapping("/story")
public class StoryController {


    @Resource
    StoryService storyService;


    @RequestMapping("/create_story")
    public Boolean createStory(@RequestBody Map<String, Object> map){
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        int cid = Integer.parseInt(map.get("cid").toString());

        Story story = new Story(cid,name,overview,"未完成");

        return storyService.createStory(story);

    }

    @RequestMapping("/update_story")
    public boolean updateStory(@RequestBody Map<String, Object> map){
        int story_id = Integer.parseInt(map.get("sid").toString());
        int cid = Integer.parseInt(map.get("cid").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        String state = map.get("state").toString();


        Story story = new Story(story_id,cid,name,overview,state);

        return storyService.updateStory(story);
    }


}

