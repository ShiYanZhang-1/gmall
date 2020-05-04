package top.shiyana.gmall.oms.dao;

import top.shiyana.gmall.oms.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:57:33
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
