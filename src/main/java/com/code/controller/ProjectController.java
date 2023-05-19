package com.code.controller;


import com.code.pojo.Project;
import com.code.pojo.Team;
import com.code.service.ProjectService;
import com.code.service.TeamService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
@RequestMapping("/project")
public class ProjectController {


    @Resource
    ProjectService projectService;

    @Resource
    TeamService teamService;




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
        Team team = new Team(pid,uid,"创建者");

        return teamService.addMembers(team);


    }


    @RequestMapping("/add_members")
    public boolean addMembers(@RequestBody Map<String, Object> map){

        int pid = Integer.parseInt(map.get("pid").toString());
        int uid = Integer.parseInt(map.get("uid").toString());
        String type = map.get("type").toString();

        Team team = new Team(pid,uid,type);

        return teamService.addMembers(team);

    }


    @RequestMapping("/get_project")
    public List<Project> getProject(@RequestBody Map<String, Object> map){


        int uid = Integer.parseInt(map.get("uid").toString());
        List<Integer> list = teamService.getProjectID(uid);



        return projectService.getProject(list);
    }





}

