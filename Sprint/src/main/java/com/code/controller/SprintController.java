package com.code.controller;


import com.code.pojo.Sprint;
import com.code.pojo.Work;
import com.code.service.SprintService;
import com.code.service.WorkService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/sprint")
public class SprintController {

    @Resource
    SprintService sprintService;

    @Resource
    WorkService workService;


    @RequestMapping("/create_sprint")
    public Boolean createSprint(@RequestBody Map<String, Object> map) throws ParseException {

        int pid = Integer.parseInt(map.get("pid").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_time = simpleDateFormat.parse(map.get("start_time").toString());
        Date end_time = simpleDateFormat.parse(map.get("end_time").toString());


        Sprint sprint = new Sprint(pid,name,overview,start_time,end_time,"未完成");

        return sprintService.createSprint(sprint);

    }

    /**
     * 返回迭代下所有任务
     * @param map
     * @return
     */
    @RequestMapping("/get_work")
    public List<Work> getAllWork(@RequestBody Map<String, Object> map){
        int sid = Integer.parseInt(map.get("sid").toString());
        List<Integer> list = new ArrayList<>();
        list.add(sid);
        return workService.getWork(list);
    }



    @RequestMapping("/update_sprint")
    public boolean updateSprint(@RequestBody Map<String, Object> map) throws ParseException {

        int sid = Integer.parseInt(map.get("sid").toString());
        int pid = Integer.parseInt(map.get("pid").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_time = simpleDateFormat.parse(map.get("start_time").toString());
        Date end_time = simpleDateFormat.parse(map.get("end_time").toString());
        String state = map.get("state").toString();


        Sprint sprint = new Sprint(sid,pid,name,overview,start_time,end_time,state);

        return sprintService.updateSprint(sprint);
    }





}

