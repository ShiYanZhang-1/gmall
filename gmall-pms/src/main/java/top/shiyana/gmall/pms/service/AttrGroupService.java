package top.shiyana.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.pms.entity.AttrGroupEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;
import top.shiyana.gmall.pms.vo.GroupVO;

import java.util.List;


/**
 * 属性分组
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:17
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo queryAttrGroupListPages(QueryCondition condition, Long catId);

    GroupVO queryGroupWithAttrsByGid(Long gid);

    List<GroupVO> queryGroupsByCatId(Long catId);
}

