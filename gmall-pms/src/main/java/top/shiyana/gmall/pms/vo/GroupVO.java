package top.shiyana.gmall.pms.vo;

import lombok.Data;
import top.shiyana.gmall.pms.entity.AttrAttrgroupRelationEntity;
import top.shiyana.gmall.pms.entity.AttrEntity;
import top.shiyana.gmall.pms.entity.AttrGroupEntity;

import java.util.List;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.pms.vo
 * @ClassName: GroupVO
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/5 10:57
 * @Version: 1.0
 */
@Data
public class GroupVO extends AttrGroupEntity {

    private List<AttrEntity> attrEntities;

    private List<AttrAttrgroupRelationEntity> relations;
}
