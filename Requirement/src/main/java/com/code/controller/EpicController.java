package com.code.controller;


import com.code.pojo.Epic;
import com.code.service.EpicService;
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
@RequestMapping("/epic")
public class EpicController {

    @Resource
    EpicService epicService;


    @RequestMapping("/create_epic")
    public Boolean createEpic(@RequestBody Map<String, Object> map){
        int pid = Integer.parseInt(map.get("pid").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();


        Epic epic = new Epic(pid,name,overview);

        return epicService.createEpic(epic);

    }

    @RequestMapping("/update_epic")
    public Boolean updateEpic(@RequestBody Map<String, Object> map){
        int eid = Integer.parseInt(map.get("eid").toString());
        int pid = Integer.parseInt(map.get("pid").toString());
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();

        Epic epic = new Epic(eid,pid,name,overview);

        return epicService.updateEpic(epic);


    }



}

