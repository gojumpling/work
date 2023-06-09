package com.code.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer projectId;

    private Integer userId;

    private String type;


    public Team(Integer projectId, Integer userId, String type) {
        this.projectId = projectId;
        this.userId = userId;
        this.type = type;
    }
}
