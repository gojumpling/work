package com.code.service;

import com.code.pojo.Work;
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
public interface WorkService extends IService<Work> {

    Boolean createWork(Work work);

    Boolean updateWork(Work work);



    /**
     * 由迭代ID列表，返回工作列表
     * @param list
     * @return
     */
    List<Work> getWork(List<Integer> list);

}
