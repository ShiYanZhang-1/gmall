package top.shiyana.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.oms.entity.OrderOperateHistoryEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 订单操作历史记录
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:57:34
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

