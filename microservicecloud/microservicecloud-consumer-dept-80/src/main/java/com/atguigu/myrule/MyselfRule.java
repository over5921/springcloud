package com.atguigu.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

/**
 * 自定义负载均衡
 * @author Acer
 *
 */
@Configuration
public class MyselfRule {
	
	@Bean
	public IRule myRule() {
//		return new RandomRule();
		return new RandomRule_ZY();
	}

}
