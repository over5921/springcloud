package com.atguigu.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.springcloud.entities.Dept;


@RestController
public class ConfigClientRest {

	@Value("${spring.application.name}")
	private String applacationname;
	
//	@Value("${eureka.client.service-url.defaultZone}")
//	private String eurekaServers;
	@Value("${spring.datasource.url}")
	private String dataSource;
	
	@Value("${server.port}")
	private String port;	
	
	@RequestMapping("/config")
	public String getConfig() {
		String str=applacationname+";"+dataSource+";"+port;
		System.out.println("***"+str);
		return str;
	}
}
