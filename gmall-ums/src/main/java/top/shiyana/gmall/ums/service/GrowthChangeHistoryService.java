package top.shiyana.gmall.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.ums.entity.GrowthChangeHistoryEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 成长值变化历史记录
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageVo queryPage(QueryCondition params);
}

