package top.shiyana.gmall.sms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.shiyana.gmall.sms.entity.HomeAdvEntity;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;


/**
 * 首页轮播广告
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
public interface HomeAdvService extends IService<HomeAdvEntity> {

    PageVo queryPage(QueryCondition params);
}

