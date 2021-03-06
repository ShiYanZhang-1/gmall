package top.shiyana.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.sms.entity.SkuBoundsEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;
import top.shiyana.gmall.sms.vo.SkuSaleVO;


/**
 * 商品sku积分设置
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageVo queryPage(QueryCondition params);

    void saveSale(SkuSaleVO skuSaleVO);
}

