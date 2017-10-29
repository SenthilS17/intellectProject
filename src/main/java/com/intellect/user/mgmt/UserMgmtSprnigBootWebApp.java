package com.intellect.user.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.intellect.user.mgmt")
public class UserMgmtSprnigBootWebApp {

	public static void main(String[] args) {
		SpringApplication.run(UserMgmtSprnigBootWebApp.class, args);
	}

}
