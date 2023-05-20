package com.code.service;

import com.code.pojo.Characteristic;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Calendar;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
public interface CharacteristicService extends IService<Characteristic> {

    Boolean createCharacteristic(Characteristic characteristic);
    Boolean updateCharacteristic(Characteristic characteristic);


    List<Characteristic> getCharacteristicByEid(int eid);

}
