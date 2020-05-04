package top.shiyana.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.ums.entity.MemberCollectSubjectEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 会员收藏的专题活动
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
public interface MemberCollectSubjectService extends IService<MemberCollectSubjectEntity> {

    PageVo queryPage(QueryCondition params);
}

