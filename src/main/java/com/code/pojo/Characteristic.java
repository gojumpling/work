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
public class Characteristic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "characteristic_id", type = IdType.AUTO)
    private Integer characteristicId;

    private Integer epicId;

    private String name;

    private String overview;


    public Characteristic(Integer epicId, String name, String overview) {
        this.epicId = epicId;
        this.name = name;
        this.overview = overview;
    }
}
