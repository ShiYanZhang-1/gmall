package top.shiyana.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.pms.entity.SkuSaleAttrValueEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * sku销售属性&值
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:17
 */
public interface SkuSaleAttrValueService extends IService<SkuSaleAttrValueEntity> {

    PageVo queryPage(QueryCondition params);
}

