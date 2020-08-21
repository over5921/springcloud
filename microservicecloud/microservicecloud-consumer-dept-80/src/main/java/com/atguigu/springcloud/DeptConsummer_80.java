package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

import com.atguigu.myrule.MyselfRule;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyselfRule.class)
public class DeptConsummer_80 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(DeptConsummer_80.class, args);
	}
	/*
	 * 自定义负载均衡算法警告：
	 * 这个自定义配置类不能放在@ComponentScan 所扫描的当前包下以及子包下，否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享
	 * 也就是说不能达到特殊化的目的了
	 * 
	 * 言外之意就是 不能跟主启动类同级 和 不能在主启动类的子包下
	 */

}
