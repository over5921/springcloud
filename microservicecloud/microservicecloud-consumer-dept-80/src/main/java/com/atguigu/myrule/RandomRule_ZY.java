package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

//需求：每台机器访问5次
public class RandomRule_ZY extends AbstractLoadBalancerRule {
	//total =0 当total ==5 以后我们指针才能往下走
	//index=0 当前对外提供服务的服务器地址
	//total需要重新置为0 但是已经达到过一个5 我们index=1
	// 微服务只有三台 所以下标到4的时候需要判断

	private int total = 0;// 总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0;// 当前提供服务的机器号

	public Server choose(ILoadBalancer lb, Object key) {
		// TODO Auto-generated method stub
		if (lb == null) {
			return null;
		}
		Server server = null;
		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();
			int serverCount = allList.size();
			if (serverCount == 0) {
				return null;
			}
			if (total < 5) {
				server = upList.get(currentIndex);
				total++;
			} else {
				total = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}
			if(server==null) {
				Thread.yield();
				continue;
			}
			if(server.isAlive()) {
				return (server);
			}
			server=null;
			Thread.yield();
		}
		return server;
	}

	@Override
	public Server choose(Object key) {
		// TODO Auto-generated method stub
		return choose(getLoadBalancer(),key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {
		// TODO Auto-generated method stub

	}

}
