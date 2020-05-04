package top.shiyana.gmall.pms.dao;

import top.shiyana.gmall.pms.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:16
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
