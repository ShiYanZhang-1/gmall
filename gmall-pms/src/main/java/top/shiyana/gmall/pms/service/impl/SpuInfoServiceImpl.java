package top.shiyana.gmall.pms.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.Query;
import com.oyyo.core.bean.QueryCondition;

import org.springframework.util.CollectionUtils;
import top.shiyana.gmall.pms.dao.SkuInfoDao;
import top.shiyana.gmall.pms.dao.SpuInfoDao;
import top.shiyana.gmall.pms.dao.SpuInfoDescDao;
import top.shiyana.gmall.pms.entity.*;
import top.shiyana.gmall.pms.feign.GamllSmsFeign;
import top.shiyana.gmall.pms.service.ProductAttrValueService;
import top.shiyana.gmall.pms.service.SkuImagesService;
import top.shiyana.gmall.pms.service.SkuSaleAttrValueService;
import top.shiyana.gmall.pms.service.SpuInfoService;
import top.shiyana.gmall.pms.vo.BaseAttrVO;
import top.shiyana.gmall.pms.vo.SkuIInfoVO;
import top.shiyana.gmall.pms.vo.SpuIInfoVO;
import top.shiyana.gmall.sms.vo.SkuSaleVO;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Resource
    private SpuInfoDescDao descDao;

    @Autowired
    private ProductAttrValueService attrValueService;

    @Resource
    private SkuInfoDao skuInfoDao;

    @Resource
    private SkuImagesService skuImagesService;

    @Resource
    private SkuSaleAttrValueService saleAttrValueService;

    @Autowired
    private GamllSmsFeign smsFeign;



    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageVo(page);
    }

    /**
     * 根据条件查询
     * @param condition
     * @param catId
     * @return
     */
    @Override
    public PageVo querySpuPage(QueryCondition condition, Long catId) {

        QueryWrapper<SpuInfoEntity> wrapper = new QueryWrapper<>();
        //判断分类是否为空
        if(catId == 0){
            catId = null;
        }
        if (catId != null ) {
            System.out.println(catId);
            wrapper.eq("catalog_id", catId);
        }

        //判断关键字是否为空
        String key = condition.getKey();
        if (StringUtils.isNotBlank(key)) {
            wrapper.and(t ->t.eq("id", key).or().like("spu_name", key));
        }

        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(condition),
                wrapper
        );

        return new PageVo(page);
    }

    @Override
    public void bigSave(SpuIInfoVO spuInfo) {
        //1保存spu相关三张表
        //1.1 保存pms_spu_info
        spuInfo.setCreateTime(new Date());
        spuInfo.setUpdateTime(spuInfo.getCreateTime());
        this.save(spuInfo);
        Long spuId = spuInfo.getId();

        //1.2保存pms_spu_info_desc
        //描述信息为空就不保存
        if (!CollectionUtils.isEmpty(spuInfo.getSpuImages())) {
            SpuInfoDescEntity descEntity = new SpuInfoDescEntity();
            descEntity.setSpuId(spuId);
            List<String> spuImages = spuInfo.getSpuImages();
            descEntity.setDecript(StringUtils.join(spuImages, ","));
            descDao.insert(descEntity);
        }

        //1.3 保存pms_spu_product_attr_value
        List<BaseAttrVO> baseAttrs = spuInfo.getBaseAttrs();
        //非空在执行保存
        if (!CollectionUtils.isEmpty(baseAttrs)) {
            List<ProductAttrValueEntity> collect = baseAttrs.stream().map(baseAttrVO -> {
                ProductAttrValueEntity valueEntity = baseAttrVO;
                valueEntity.setSpuId(spuId);
                return valueEntity;
            }).collect(Collectors.toList());
            attrValueService.saveBatch(collect);
        }

        //2保存sku相关三张表
        List<SkuIInfoVO> skus = spuInfo.getSkus();
        if (CollectionUtils.isEmpty(skus)) {
            return;
        }
        skus.forEach(skuIInfoVO -> {
            skuIInfoVO.setSpuId(spuId);
            skuIInfoVO.setSkuCode(UUID.randomUUID().toString());
            skuIInfoVO.setBrandId(spuInfo.getBrandId());
            skuIInfoVO.setCatalogId(spuInfo.getCatalogId());
            List<String> images = skuIInfoVO.getImages();
            if (!CollectionUtils.isEmpty(images)) {
                skuIInfoVO.setSkuDefaultImg(StringUtils.isNotBlank(skuIInfoVO.getSkuDefaultImg())?skuIInfoVO.getSkuDefaultImg():images.get(0));
            }

            skuInfoDao.insert(skuIInfoVO);

            Long skuId = skuIInfoVO.getSkuId();
            if (!CollectionUtils.isEmpty(images)) {
                List<SkuImagesEntity> collect = images.stream().map(image -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setImgUrl(image);
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setDefaultImg(StringUtils.equals(image, skuIInfoVO.getSkuDefaultImg()) ? 0 : 1);
                    return skuImagesEntity;
                }).collect(Collectors.toList());
                skuImagesService.saveBatch(collect);
            }
            List<SkuSaleAttrValueEntity> saleAttrs = skuIInfoVO.getSaleAttrs();
            if (!CollectionUtils.isEmpty(saleAttrs)) {
                saleAttrs.forEach(skuSaleAttrValueEntity -> skuSaleAttrValueEntity.setSkuId(skuId));
                saleAttrValueService.saveBatch(saleAttrs);
            }


            //3  远程feign调用sms-servic服务  保存营销相关的三张表
            SkuSaleVO skuSaleVO = new SkuSaleVO();
            BeanUtils.copyProperties(skuIInfoVO, skuSaleVO);
            skuSaleVO.setSkuId(skuId);
            smsFeign.saveSale(skuSaleVO);
        });



    }

}