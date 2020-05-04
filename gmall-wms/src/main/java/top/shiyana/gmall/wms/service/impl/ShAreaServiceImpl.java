package top.shiyana.gmall.wms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import top.shiyana.gmall.wms.dao.ShAreaDao;
import top.shiyana.gmall.wms.entity.ShAreaEntity;
import top.shiyana.gmall.wms.service.ShAreaService;


@Service("shAreaService")
public class ShAreaServiceImpl extends ServiceImpl<ShAreaDao, ShAreaEntity> implements ShAreaService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ShAreaEntity> page = this.page(
                new Query<ShAreaEntity>().getPage(params),
                new QueryWrapper<ShAreaEntity>()
        );

        return new PageVo(page);
    }

}