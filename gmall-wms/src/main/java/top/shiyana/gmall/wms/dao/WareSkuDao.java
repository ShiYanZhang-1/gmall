package top.shiyana.gmall.wms.dao;

import top.shiyana.gmall.wms.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:07:57
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}
