package top.shiyana.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.pms.entity.ProductAttrValueEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * spu属性值
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:16
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageVo queryPage(QueryCondition params);
}

