package top.shiyana.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.sms.entity.SeckillSessionEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 秒杀活动场次
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageVo queryPage(QueryCondition params);
}

