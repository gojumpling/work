package com.code.service;

import com.code.pojo.Sprint;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
public interface SprintService extends IService<Sprint> {


    /**
     * 创建一个迭代
     * @param sprint
     * @return Boolean
     */
    Boolean createSprint(Sprint sprint);

    Boolean updateSprint(Sprint sprint);

    List<Integer> getSprintID(int pid);

}
