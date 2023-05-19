package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "word_id", type = IdType.AUTO)
    private Integer wordId;

    private Integer sprintId;

    private Integer storyId;

    @TableField("user_Id")
    private Integer userId;

    private String name;

    private String state;


    public Work(Integer sprintId, Integer storyId, Integer userId, String name) {
        this.sprintId = sprintId;
        this.storyId = storyId;
        this.userId = userId;
        this.name = name;

    }
}
