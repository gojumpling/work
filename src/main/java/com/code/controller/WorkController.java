package com.code.controller;


import com.code.pojo.Sprint;
import com.code.pojo.Work;
import com.code.service.SprintService;
import com.code.service.WorkService;
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
public class WorkController {


    @Resource
    WorkService workService;


    @RequestMapping("/create_work")
    public int createWork(@RequestBody Map<String, Object> map){

        String name = map.get("name").toString();
//        String overview = map.get("overview").toString();
        int uid = Integer.parseInt(map.get("uid").toString());
        int story_id = Integer.parseInt(map.get("story_id").toString());
        int sprint_id = Integer.parseInt(map.get("sprint_id").toString());

        Work work = new Work(sprint_id,story_id,uid,name);

        return workService.createWork(work);

    }


    @RequestMapping("/finish_work")
    public boolean finishWork(@RequestBody Map<String, Object> map){
        int work_id = Integer.parseInt(map.get("wid").toString());

        return workService.finishWork(work_id);
    }

}

