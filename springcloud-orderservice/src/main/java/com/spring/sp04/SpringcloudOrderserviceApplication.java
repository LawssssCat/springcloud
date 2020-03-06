package com.spring.sp04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableDiscoveryClient  springcloud包含了
//@SpringBootApplication  springcloud包含了

@EnableFeignClients
@SpringCloudApplication
public class SpringcloudOrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudOrderserviceApplication.class, args);
	}

}
