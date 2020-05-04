package top.shiyana.gmall.sms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import top.shiyana.gmall.sms.dao.SpuLadderDao;
import top.shiyana.gmall.sms.entity.SpuLadderEntity;
import top.shiyana.gmall.sms.service.SpuLadderService;


@Service("spuLadderService")
public class SpuLadderServiceImpl extends ServiceImpl<SpuLadderDao, SpuLadderEntity> implements SpuLadderService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuLadderEntity> page = this.page(
                new Query<SpuLadderEntity>().getPage(params),
                new QueryWrapper<SpuLadderEntity>()
        );

        return new PageVo(page);
    }

}