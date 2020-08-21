package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_9527_StartSpringCloudApp {

	//http://myzuul.com:9527/microservicecloud-dept/dept/get/1
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(Zuul_9527_StartSpringCloudApp.class, args);
	}

}
