package top.shiyana.gmall.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@MapperScan("top.shiyana.gmall.wms.dao")
public class GmallWmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallWmsApplication.class, args);
    }

}
