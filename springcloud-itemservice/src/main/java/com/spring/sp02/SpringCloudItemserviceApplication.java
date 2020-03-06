package com.spring.sp02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudItemserviceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		StopWatch clock = new StopWatch() ;
		clock.start("启动SpringBoot项目");
		SpringApplication.run(SpringCloudItemserviceApplication.class, args);
		clock.stop();
		log.info("=================================== 启动完毕,用时:{} seconds ==================================",clock.getTotalTimeSeconds());
	}

	@Autowired
	private ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		String[] names = context.getBeanDefinitionNames();
		int n = 1 ; 
		for (String name : names) {
			log.info("{}:{}", n++, name);
		}
	}

}
