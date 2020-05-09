package top.shiyana.gmall.sms.api;

import com.oyyo.core.bean.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import top.shiyana.gmall.sms.vo.SkuSaleVO;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.sms.api
 * @ClassName: GmallSmsApi
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 21:56
 * @Version: 1.0
 */
public interface GmallSmsApi {

    @PostMapping("sms/skubounds/sku/sale/save")
    Resp<Object> saveSale(@RequestBody SkuSaleVO skuSaleVO);

}
