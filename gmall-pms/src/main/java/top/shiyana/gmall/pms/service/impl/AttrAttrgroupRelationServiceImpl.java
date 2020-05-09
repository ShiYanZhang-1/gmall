package top.shiyana.gmall.pms.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import top.shiyana.gmall.pms.dao.AttrAttrgroupRelationDao;
import top.shiyana.gmall.pms.entity.AttrAttrgroupRelationEntity;
import top.shiyana.gmall.pms.service.AttrAttrgroupRelationService;


@Service("attrAttrgroupRelationService")
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationDao, AttrAttrgroupRelationEntity> implements AttrAttrgroupRelationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrAttrgroupRelationEntity> page = this.page(
                new Query<AttrAttrgroupRelationEntity>().getPage(params),
                new QueryWrapper<AttrAttrgroupRelationEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public void removeRelations(List<AttrAttrgroupRelationEntity> relations) {
        relations.forEach(attrAttrgroupRelationEntity -> {
            this.remove(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",
                    attrAttrgroupRelationEntity.getAttrId()).eq("attr_group_id", attrAttrgroupRelationEntity.getAttrGroupId()));
        });
    }

}