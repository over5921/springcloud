package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EnableConfig_3344_App {
//http://config-3344.com:3344/application-dev.yml
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(EnableConfig_3344_App.class, args);
	}

}
