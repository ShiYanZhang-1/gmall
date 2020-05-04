package top.shiyana.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.sms.entity.SeckillSkuNoticeEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 秒杀商品通知订阅
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageVo queryPage(QueryCondition params);
}

