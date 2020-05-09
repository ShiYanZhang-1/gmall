package top.shiyana.gmall.sms.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.sms.vo
 * @ClassName: top.shiyana.gmall.sms.vo.SkuSaleVO
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 19:50
 * @Version: 1.0
 */
@Data
public class SkuSaleVO {

    private Long skuId;

    //积分营销相关的字段
    private BigDecimal growBounds;
    private BigDecimal buyBounds;
    private List<Integer> work;

    //打折营销相关的字段
    private Integer fullCount;
    private BigDecimal discount;
    private Integer ladderAddOther;

    //满减相关的字段
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private Integer fullAddOther;

}
