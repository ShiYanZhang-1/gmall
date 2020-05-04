package top.shiyana.gmall.sms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ProjectName: gmall
 * @Package: top.shiyana.gmall.pms.config
 * @ClassName: MySecurityConfig
 * @Author: dangerous
 * @Description:
 * @Date: 2020/5/4 15:32
 * @Version: 1.0
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
        http.csrf();
    }
}
