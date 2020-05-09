package top.shiyana.gmall.pms.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;
import top.shiyana.gmall.pms.dao.AttrAttrgroupRelationDao;
import top.shiyana.gmall.pms.dao.AttrDao;
import top.shiyana.gmall.pms.dao.AttrGroupDao;
import top.shiyana.gmall.pms.entity.AttrAttrgroupRelationEntity;
import top.shiyana.gmall.pms.entity.AttrEntity;
import top.shiyana.gmall.pms.entity.AttrGroupEntity;
import top.shiyana.gmall.pms.service.AttrGroupService;
import top.shiyana.gmall.pms.vo.GroupVO;

import javax.annotation.Resource;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Resource
    private AttrAttrgroupRelationDao relationDao;

    @Resource
    private AttrDao attrDao;

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public PageVo queryAttrGroupListPages(QueryCondition condition, Long catId) {

        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();
        if (catId != null) {
            queryWrapper.eq("catelog_id", catId);
        }

        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(condition),
                queryWrapper
        );

        return new PageVo(page);
    }

    @Override
    public GroupVO queryGroupWithAttrsByGid(Long gid) {
        GroupVO groupVO = new GroupVO();
        //查询group表的相关信息
        AttrGroupEntity byId = this.getById(gid);
        BeanUtils.copyProperties(byId, groupVO);
        //根据group_id在属性关系表中查询属性attr_ids
        List<AttrAttrgroupRelationEntity> relations = relationDao.selectList(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_group_id", gid));
        if (CollectionUtils.isEmpty(relations)) {
           return groupVO;
        }
        groupVO.setRelations(relations);
        //根据attr_ids查询规格参数
        List<Long> attrIds = relations.stream().map(attrAttrgroupRelationEntity -> attrAttrgroupRelationEntity.getAttrId()).collect(Collectors.toList());
        List<AttrEntity> attrEntities = attrDao.selectBatchIds(attrIds);
        if (CollectionUtils.isEmpty(attrEntities)) {
            return groupVO;
        }
        groupVO.setAttrEntities(attrEntities);
        return groupVO;
    }

    @Override
    public List<GroupVO> queryGroupsByCatId(Long catId) {
        //根据cateId分类（手机）id 查出所有的属性分组
        List<AttrGroupEntity> list = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catId));
        //根据分组表的分组id 查询中间表属性值
        return list.stream().map(attrGroupEntity -> this.queryGroupWithAttrsByGid(attrGroupEntity.getAttrGroupId())).collect(Collectors.toList());
    }

}