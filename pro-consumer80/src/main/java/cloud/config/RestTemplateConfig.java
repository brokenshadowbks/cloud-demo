package cloud.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {//80调用8001传递地址；参数；返回数据data

    @Bean

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}