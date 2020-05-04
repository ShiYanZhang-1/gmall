package top.shiyana.gmall.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.oms.entity.RefundInfoEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 退款信息
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:57:34
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageVo queryPage(QueryCondition params);
}

