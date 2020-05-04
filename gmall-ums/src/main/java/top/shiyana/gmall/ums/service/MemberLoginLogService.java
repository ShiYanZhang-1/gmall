package top.shiyana.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.ums.entity.MemberLoginLogEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 会员登录记录
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
public interface MemberLoginLogService extends IService<MemberLoginLogEntity> {

    PageVo queryPage(QueryCondition params);
}

