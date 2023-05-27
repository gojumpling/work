package com.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.code.pojo.Characteristic;
import com.code.mapper.CharacteristicMapper;
import com.code.service.CharacteristicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@Service
public class CharacteristicServiceImpl extends ServiceImpl<CharacteristicMapper, Characteristic> implements CharacteristicService {

    @Override
    public Boolean createCharacteristic(Characteristic characteristic) {
        return this.save(characteristic);

    }

    @Override
    public Boolean updateCharacteristic(Characteristic characteristic) {
        return this.updateById(characteristic);
    }

    @Override
    public List<Characteristic> getCharacteristicByEid(int eid) {
        LambdaQueryWrapper<Characteristic> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Characteristic::getEpicId,eid);
        return this.list(lambdaQueryWrapper);
    }


}
