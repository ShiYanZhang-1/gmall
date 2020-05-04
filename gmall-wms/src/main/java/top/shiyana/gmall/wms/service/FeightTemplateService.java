package top.shiyana.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.wms.entity.FeightTemplateEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 运费模板
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:07:57
 */
public interface FeightTemplateService extends IService<FeightTemplateEntity> {

    PageVo queryPage(QueryCondition params);
}

