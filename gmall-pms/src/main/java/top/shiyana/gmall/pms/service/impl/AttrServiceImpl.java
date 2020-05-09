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
import top.shiyana.gmall.pms.dao.AttrDao;
import top.shiyana.gmall.pms.entity.AttrAttrgroupRelationEntity;
import top.shiyana.gmall.pms.entity.AttrEntity;
import top.shiyana.gmall.pms.entity.AttrGroupEntity;
import top.shiyana.gmall.pms.service.AttrService;
import top.shiyana.gmall.pms.vo.AttrVO;
import top.shiyana.gmall.pms.vo.GroupVO;

import javax.annotation.Resource;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Resource
    private AttrAttrgroupRelationDao relationDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryAttrsByCid(QueryCondition condition, Long cid, Integer type) {

        QueryWrapper<AttrEntity> wrapper = new QueryWrapper<>();

        if (cid != null) {
            wrapper.eq("catelog_id", cid);
        }
        wrapper.eq("attr_type", type);
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(condition),
                wrapper
        );

        return new PageVo(page);
    }

    @Override
    public void saveAttr(AttrVO attr) {

        //保存attr属性
        this.save(attr);
        Long attrId = attr.getAttrId();
        //保存属性关系中间表
        AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
        relationEntity.setAttrId(attrId);
        relationEntity.setAttrGroupId(attr.getAttrGroupId());
        relationDao.insert(relationEntity);

    }


}