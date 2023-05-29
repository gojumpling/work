package com.code.client;

import com.code.pojo.Team;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient("user-service")
public interface TeamClient {

    @RequestMapping("/team/add_members")
    Boolean addMembers(@RequestBody Map<String, Object> map);

    @RequestMapping("/team/get_project")
    List<Integer> getProjectID(@RequestBody Map<String, Object> map);

}
