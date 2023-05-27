package com.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExtendEpic implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "epic_id", type = IdType.AUTO)
    private Integer epicId;

    private Integer projectId;

    private String name;

    private String overview;

    private List<ExtendCharacteristic> characteristic_List;

}
