package com.cafe24.springex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication //아래 3개를 한번에 설정하는 어노테이션 방식

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.cafe24.springex.controller")
public class BootApplication { // configuration 파일 자체가 된다.
	
	// tomcat이 임베디드화 되어 단독으로 메모리에 올라가는 형식\
	// embeded Tomcat jar 파일로 따로 빠져있음
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
