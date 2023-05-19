package com.code.service;

import com.code.pojo.Work;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
public interface WorkService extends IService<Work> {

    int createWork(Work work);
    boolean finishWork(int wid);

}
