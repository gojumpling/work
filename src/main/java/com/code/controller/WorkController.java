package com.code.controller;


import com.code.pojo.Sprint;
import com.code.pojo.Work;
import com.code.service.SprintService;
import com.code.service.WorkService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
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
@RequestMapping("/work")
public class WorkController {


    @Resource
    WorkService workService;

    @Resource
    SprintService sprintService;


    /**
     * 创建任务，任务状态设为 未完成
     * @param map
     * @return
     */
    @RequestMapping("/create_work")
    public Boolean createWork(@RequestBody Map<String, Object> map){

        String name = map.get("name").toString();
        String overview = map.get("overview").toString();

        int uid = Integer.parseInt(map.get("uid").toString());
        int story_id = Integer.parseInt(map.get("story_id").toString());
        int sprint_id = Integer.parseInt(map.get("sprint_id").toString());

        Work work = new Work(sprint_id,story_id,uid,name,overview,"未完成");

        return workService.createWork(work);

    }


    /**
     * 更新任务
     * @param map
     * @return
     */
    @RequestMapping("/update_work")
    public boolean updateWork(@RequestBody Map<String, Object> map){
        int work_id = Integer.parseInt(map.get("wid").toString());
        int uid = Integer.parseInt(map.get("uid").toString());
        int story_id = Integer.parseInt(map.get("story_id").toString());
        int sprint_id = Integer.parseInt(map.get("sprint_id").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        String state = map.get("state").toString();

        Work work = new Work(work_id,story_id,sprint_id,uid,name,overview,state);

        return workService.updateWork(work);
    }





    /**
     * 返回项目下的所有任务
     * 流程：先获取到迭代ID列表，由迭代ID列表获取到任务列表
     * @param map
     * @return
     */
    @RequestMapping("/get_work")
    public List<Work> getWork(@RequestBody Map<String, Object> map){

        int pid = Integer.parseInt(map.get("pid").toString());
        List<Integer> list = sprintService.getSprintID(pid);

        return workService.getWork(list);
    }




}

