package com.code.service;

import com.code.pojo.Epic;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
public interface EpicService extends IService<Epic> {

    Boolean createEpic(Epic epic);

}
