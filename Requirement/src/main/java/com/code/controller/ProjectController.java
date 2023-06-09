package com.code.controller;


import com.code.bean.EpicIterator;
import com.code.bean.ExtendCharacteristic;
import com.code.bean.ExtendEpic;
import com.code.client.TeamClient;
import com.code.pojo.*;
import com.code.service.CharacteristicService;
import com.code.service.EpicService;
import com.code.service.ProjectService;
import com.code.service.StoryService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@RestController
@RequestMapping("/project")
public class ProjectController {


    @Resource
    ProjectService projectService;

    @Resource
    TeamClient teamClient;


    @Resource
    EpicService epicService;
    @Resource
    CharacteristicService characteristicService;
    @Resource
    StoryService storyService;




    @RequestMapping("/create_project")
    public Boolean createProject(@RequestBody Map<String, Object> map) throws ParseException {

        String topic = map.get("topic").toString();
        String overview = map.get("overview").toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start_time = simpleDateFormat.parse(map.get("start_time").toString());
        Date end_time = simpleDateFormat.parse(map.get("end_time").toString());

        Project project = new Project(start_time,end_time,topic,overview);


        int pid = projectService.createProject(project);
        int uid = Integer.parseInt(map.get("uid").toString());
        Map<String, Object> team = new HashMap<>();
        team.put("pid",pid);
        team.put("uid",uid);
        team.put("type","创建者");
        return teamClient.addMembers(team);

    }



    @RequestMapping("/get_project")
    public List<Project> getProject(@RequestBody Map<String, Object> map){


        List<Integer> list = teamClient.getProjectID(map);

        return projectService.getProject(list);
    }



    @RequestMapping("get_requirement")
    public Map<String,Object> getRequirement(@RequestBody Map<String, Object> map){
        int pid = Integer.parseInt(map.get("pid").toString());

        Project project = projectService.getProjectById(pid);
        List<ExtendEpic> extendEpicList = new ArrayList<>();

        List<Epic> epicList = epicService.getEpicByPid(pid);

        for (Epic epic:epicList) {

            int eid = epic.getEpicId();

            List<Characteristic> characteristicList = characteristicService.getCharacteristicByEid(eid);

            List<ExtendCharacteristic> extendCharacteristicList = new ArrayList<>();

            for (Characteristic c:characteristicList) {
                int cid = c.getCharacteristicId();
                List<Story> storyList = storyService.getStoryByCid(cid);

                ExtendCharacteristic extendCharacteristic = new ExtendCharacteristic(c.getCharacteristicId(),c.getEpicId(),c.getName(),c.getOverview(),storyList);

                extendCharacteristicList.add(extendCharacteristic);

            }

            ExtendEpic extendEpic = new ExtendEpic(epic.getEpicId(),epic.getProjectId(),epic.getName(),epic.getOverview(),extendCharacteristicList);

            extendEpicList.add(extendEpic);
        }


        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("project",project);
        objectMap.put("epic_list",extendEpicList);


        return objectMap;


    }





}

