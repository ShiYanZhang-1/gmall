package top.shiyana.gmall.pms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import top.shiyana.gmall.sms.api.GmallSmsApi;
/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.pms.feign
 * @ClassName: GamllSmsFeign
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/7 21:01
 * @Version: 1.0
 */
@FeignClient("sms-service")
public interface GamllSmsFeign extends GmallSmsApi {


}
