package top.shiyana.gmall.pms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.pms.entity.SpuCommentEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 商品评价
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:17
 */
public interface SpuCommentService extends IService<SpuCommentEntity> {

    PageVo queryPage(QueryCondition params);
}

