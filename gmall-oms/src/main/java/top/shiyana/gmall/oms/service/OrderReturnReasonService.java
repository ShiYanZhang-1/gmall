package top.shiyana.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.oms.entity.OrderReturnReasonEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 退货原因
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:57:34
 */
public interface OrderReturnReasonService extends IService<OrderReturnReasonEntity> {

    PageVo queryPage(QueryCondition params);
}

