package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoshuai
 * @since 2023-05-12
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    private Date startTime;

    private Date endTime;

    private String topic;

    private String overview;



    public Project(Date startTime, Date endTime, String topic, String overview) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.topic = topic;
        this.overview = overview;
    }

    public Integer getProjectId() {
        return projectId;
    }
}
