package top.shiyana.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.ums.entity.IntegrationChangeHistoryEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 积分变化历史记录
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

