package top.shiyana.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.wms.entity.WareOrderTaskEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 库存工作单
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:07:57
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageVo queryPage(QueryCondition params);
}

