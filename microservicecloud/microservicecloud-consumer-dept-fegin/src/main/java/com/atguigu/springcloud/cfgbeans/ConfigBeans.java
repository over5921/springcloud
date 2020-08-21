package com.atguigu.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class ConfigBeans {

	@Bean
	@LoadBalanced //springcloud Ribbon 是基于Netflix Ribbon 实现的一套客户端负载均衡的工具
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}
	/**
	 * 负载均衡算法
	 * RoundRobinRule 轮询
	 * RandomRule 随机
	 * RetryRule 先按照RoundRobinRule的策略获取服务，如果获取服务失败则在指定时间内会进行重试，获取可用的服务
	 * @return
	 */
	@Bean
	public IRule myRule() {
//		return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询
		return new RetryRule();//
	}
}
