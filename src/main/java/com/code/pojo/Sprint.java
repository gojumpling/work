package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Sprint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sprint_id", type = IdType.AUTO)
    private Integer sprintId;

    private Integer projectId;

    private String name;

    private String overview;

    private Date startTime;

    private Date endTime;

    private String state;


    public Sprint(Integer projectId, String name, String overview, Date startTime, Date endTime, String state) {
        this.projectId = projectId;
        this.name = name;
        this.overview = overview;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }
}
