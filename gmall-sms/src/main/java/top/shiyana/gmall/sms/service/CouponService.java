package top.shiyana.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.sms.entity.CouponEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 优惠券信息
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
public interface CouponService extends IService<CouponEntity> {

    PageVo queryPage(QueryCondition params);
}

