package cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan("cloud.mapper") //
@SpringBootApplication
@EnableDiscoveryClient //服务注册和发现
@RefreshScope
public class Main8005 {
    public static void main(String[] args)
    {
        SpringApplication.run(Main8005.class,args);
    }

}