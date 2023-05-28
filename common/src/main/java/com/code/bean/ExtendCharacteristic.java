package com.code.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.code.pojo.Characteristic;
import com.code.pojo.Story;
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
public class ExtendCharacteristic extends Characteristic {

    private List<Story> story_list;


    public ExtendCharacteristic(Integer characteristicId, Integer epicId, String name, String overview, List<Story> storyList) {
        setCharacteristicId(characteristicId);
        setEpicId(epicId);
        setName(name);
        setOverview(overview);
        this.story_list = storyList;
    }

    public List<Story> getStory_list() {
        return story_list;
    }
}
