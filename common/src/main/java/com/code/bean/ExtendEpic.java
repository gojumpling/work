package com.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.code.pojo.Epic;
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
public class ExtendEpic extends Epic {


    private List<ExtendCharacteristic> characteristic_List;

    public ExtendEpic(Integer epicId, Integer projectId, String name, String overview, List<ExtendCharacteristic> extendCharacteristicList) {
        this.setEpicId(epicId);
        setProjectId(projectId);
        setName(name);
        setOverview(overview);
        this.characteristic_List = extendCharacteristicList;
    }

    public List<ExtendCharacteristic> getCharacteristic_List() {
        return characteristic_List;
    }
}
