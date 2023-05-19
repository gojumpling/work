package com.code.controller;


import com.code.pojo.Characteristic;
import com.code.service.CharacteristicService;
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
@RequestMapping("/characteristic")
public class CharacteristicController {


    @Resource
    CharacteristicService characteristicService;


    @RequestMapping("/create_characteristic")
    public Boolean createCharacteristic(@RequestBody Map<String, Object> map){
        String name = map.get("name").toString();
        String overview = map.get("overview").toString();
        int eid = Integer.parseInt(map.get("eid").toString());

        Characteristic characteristic = new Characteristic(eid,name,overview);

        return characteristicService.createCharacteristic(characteristic);

    }


}



