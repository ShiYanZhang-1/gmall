package top.shiyana.gmall.pms.dao;

import top.shiyana.gmall.pms.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:16
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
