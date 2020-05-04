package top.shiyana.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.pms.entity.CategoryEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 商品三级分类
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:16
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageVo queryPage(QueryCondition params);
}

