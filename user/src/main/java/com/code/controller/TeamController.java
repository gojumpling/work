package com.code.controller;



import com.code.pojo.Team;
import com.code.pojo.User;
import com.code.service.TeamService;
import com.code.service.UserService;
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
@RequestMapping("/team")
public class TeamController {


    @Resource
    TeamService teamService;

    @Resource
    UserService userService;



    @RequestMapping("/add_members")
    public boolean addMembers(@RequestBody Map<String, Object> map){

        int pid = Integer.parseInt(map.get("pid").toString());
        int uid = Integer.parseInt(map.get("uid").toString());
        String type = map.get("type").toString();

        Team team = new Team(pid,uid,type);

        return teamService.addMembers(team);

    }

    @RequestMapping("/get_members")
    public List<User> getMembers(@RequestBody Map<String, Object> map){
        int pid = Integer.parseInt(map.get("pid").toString());

        List<Integer> list = teamService.getUserID(pid);
        return userService.getUser(list);

    }

    @RequestMapping("/change_type")
    public Boolean changeType(@RequestBody Map<String, Object> map){
        int pid = Integer.parseInt(map.get("pid").toString());
        int uid = Integer.parseInt(map.get("uid").toString());
        String type = map.get("type").toString();
        Team team = new Team(pid,uid,type);
        return teamService.changeType(team);

    }

    // 仅供需求模块远程调用
    @RequestMapping("/getProjectID")
    List<Integer> getProjectID(int uid){
        return teamService.getProjectID(uid);
    }






}

