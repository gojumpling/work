package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class Epic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "epic_id", type = IdType.AUTO)
    private Integer epicId;

    private Integer projectId;

    private String name;

    private String overview;

    public Epic(Integer projectId, String name, String overview) {
        this.projectId = projectId;
        this.name = name;
        this.overview = overview;
    }
}
