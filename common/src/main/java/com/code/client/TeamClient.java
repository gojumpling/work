package com.code.client;

import com.code.pojo.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("user-service")
public interface TeamClient {

    @RequestMapping("/team/add_members")
    Boolean addMembers(Team team);


    @RequestMapping("/get_members")
    List<Integer> getProjectID(int uid);

}
