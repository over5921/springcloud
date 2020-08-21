package com.atguigu.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.atguigu.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

//	private static final String REST_URL_PREFI="http://localhost:8001";
	private static final String REST_URL_PREFI="http://MICROSERVICECLOUD-DEPT";//微服务访问
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/consummer/dept/list")
	public List<Dept> list() {  
		// 请求地址；请求参数；Http相应对象类型
		return  restTemplate.getForObject(REST_URL_PREFI+"/dept/list", List.class);
	}
	
	@GetMapping("/consummer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		// 请求地址；请求参数；Http相应对象类型
		return  restTemplate.getForObject(REST_URL_PREFI+"/dept/get/"+id, Dept.class);
	}
	
	//消费端也可以调用服务发现
	@GetMapping("/consummer/dept/discovery")
	public Object discovery() {
		return  restTemplate.getForObject(REST_URL_PREFI+"/dept/discovery", Object.class);
	}
}
