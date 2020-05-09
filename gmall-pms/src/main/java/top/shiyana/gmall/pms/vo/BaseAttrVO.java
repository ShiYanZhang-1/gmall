package top.shiyana.gmall.pms.vo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import top.shiyana.gmall.pms.entity.ProductAttrValueEntity;

import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.pms.vo
 * @ClassName: BaseAttrVO
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 17:10
 * @Version: 1.0
 */
@Data
public class BaseAttrVO extends ProductAttrValueEntity {

    public void setValueSelected(List<String> values){
        if(CollectionUtils.isEmpty(values)){
            return;
        }
        String join = StringUtils.join(values, ",");
        this.setAttrValue(join);
    }

}
