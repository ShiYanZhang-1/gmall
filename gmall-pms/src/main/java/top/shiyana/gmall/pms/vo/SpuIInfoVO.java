package top.shiyana.gmall.pms.vo;

import lombok.Data;
import top.shiyana.gmall.pms.entity.SpuInfoEntity;

import java.util.List;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.pms.vo
 * @ClassName: SpuIInfoVO
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 17:07
 * @Version: 1.0
 */
@Data
public class SpuIInfoVO extends SpuInfoEntity {

    private List<String> spuImages;

    private List<BaseAttrVO> baseAttrs;

    private List<SkuIInfoVO> skus;

}
