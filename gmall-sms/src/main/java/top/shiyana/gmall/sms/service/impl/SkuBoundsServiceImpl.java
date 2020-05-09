package top.shiyana.gmall.sms.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import top.shiyana.gmall.sms.dao.SkuBoundsDao;
import top.shiyana.gmall.sms.dao.SkuFullReductionDao;
import top.shiyana.gmall.sms.dao.SkuLadderDao;
import top.shiyana.gmall.sms.entity.SkuBoundsEntity;
import top.shiyana.gmall.sms.entity.SkuFullReductionEntity;
import top.shiyana.gmall.sms.entity.SkuLadderEntity;
import top.shiyana.gmall.sms.service.SkuBoundsService;
import top.shiyana.gmall.sms.vo.SkuSaleVO;

import javax.annotation.Resource;


@Service("skuBoundsService")
public class SkuBoundsServiceImpl extends ServiceImpl<SkuBoundsDao, SkuBoundsEntity> implements SkuBoundsService {

    @Resource
    private SkuLadderDao ladderDao;

    @Resource
    private SkuFullReductionDao reductionDao;


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SkuBoundsEntity> page = this.page(
                new Query<SkuBoundsEntity>().getPage(params),
                new QueryWrapper<SkuBoundsEntity>()
        );

        return new PageVo(page);
    }

    @Override
    public void saveSale(SkuSaleVO skuSaleVO) {
        SkuBoundsEntity skuBoundsEntity = new SkuBoundsEntity();
        skuBoundsEntity.setSkuId(skuSaleVO.getSkuId());
        skuBoundsEntity.setGrowBounds(skuSaleVO.getGrowBounds());
        skuBoundsEntity.setBuyBounds(skuSaleVO.getBuyBounds());
        List<Integer> work = skuSaleVO.getWork();
        skuBoundsEntity.setWork(work.get(3) * 1 + work.get(2) * 2 + work.get(1) * 4 + work.get(0) * 8);
        this.save(skuBoundsEntity);


        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(skuSaleVO.getSkuId());
        skuLadderEntity.setFullCount(skuSaleVO.getFullCount());
        skuLadderEntity.setDiscount(skuSaleVO.getDiscount());
        skuLadderEntity.setAddOther(skuSaleVO.getLadderAddOther());
        ladderDao.insert(skuLadderEntity);

        SkuFullReductionEntity skuFullReductionEntity = new SkuFullReductionEntity();
        skuFullReductionEntity.setSkuId(skuSaleVO.getSkuId());
        skuFullReductionEntity.setReducePrice(skuSaleVO.getReducePrice());
        skuFullReductionEntity.setFullPrice(skuSaleVO.getFullPrice());
        skuFullReductionEntity.setAddOther(skuSaleVO.getFullAddOther());
        reductionDao.insert(skuFullReductionEntity);
    }



}