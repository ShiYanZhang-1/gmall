package top.shiyana.gmall.ums.dao;

import top.shiyana.gmall.ums.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:05:13
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
