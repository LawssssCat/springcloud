package com.spring.sp03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudUserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudUserserviceApplication.class, args);
	}

}
