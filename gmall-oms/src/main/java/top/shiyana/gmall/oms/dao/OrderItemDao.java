package top.shiyana.gmall.oms.dao;

import top.shiyana.gmall.oms.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:57:34
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
