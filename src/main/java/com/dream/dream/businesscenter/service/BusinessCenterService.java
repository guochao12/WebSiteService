/**
 																																																																																																																																																																																				* OperationsCenterService.java
 */
package com.dream.dream.businesscenter.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.corundumstudio.socketio.AuthorizationListener;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;

/**
 * 
 * @ClassName: BusinessCenterService
 * @Description: TODO
 * @author: sjb242010
 * @date: 2017年3月27日 下午4:17:23
 */
@SpringBootApplication
//指定扫描的mapper接口所在的包
@MapperScan(value={"com/dream/dream/businesscenter/service/**/mapper"})
//启动注解事务管理
//push Test
@EnableTransactionManagement
@Controller
public class BusinessCenterService extends SpringBootServletInitializer {

    @Autowired
    private RestTemplateBuilder builder;
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BusinessCenterService.class);
    }

    //使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }
    
    @RequestMapping("/")
	public String index(){
		return "index";
	}

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BusinessCenterService.class, args);
    }
}