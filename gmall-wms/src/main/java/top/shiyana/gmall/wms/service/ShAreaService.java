package top.shiyana.gmall.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.wms.entity.ShAreaEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 全国省市区信息
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:07:57
 */
public interface ShAreaService extends IService<ShAreaEntity> {

    PageVo queryPage(QueryCondition params);
}

