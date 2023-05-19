package com.code.controller;


import com.code.pojo.Sprint;
import com.code.pojo.Story;
import com.code.service.SprintService;
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
@RequestMapping("/sprint")
public class SprintController {

    @Resource
    SprintService sprintService;


    @RequestMapping("/create_sprint")
    public int createSprint(@RequestBody Map<String, Object> map){

        String overview = map.get("overview").toString();
        int pid = Integer.parseInt(map.get("pid").toString());

        Sprint sprint = new Sprint(pid,overview);

        return sprintService.createSprint(sprint);

    }




}

