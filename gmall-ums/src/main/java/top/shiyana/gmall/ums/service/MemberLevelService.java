package top.shiyana.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.ums.entity.MemberLevelEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 会员等级
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
public interface MemberLevelService extends IService<MemberLevelEntity> {

    PageVo queryPage(QueryCondition params);
}

