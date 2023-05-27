package com.code.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

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
public class Story implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "story_id", type = IdType.AUTO)
    private Integer storyId;

    private Integer characteristicId;

    private String name;

    private String overview;

    private String state;

    public Story(Integer characteristicId, String name, String overview,String state) {
        this.characteristicId = characteristicId;
        this.name = name;
        this.overview = overview;
        this.state = state;
    }
}
