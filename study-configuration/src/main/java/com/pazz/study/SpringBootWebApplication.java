package com.pazz.study;

import com.pazz.study.filter.TestServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean testServlet(){
		return new ServletRegistrationBean(new TestServlet(), "/");
	}

}
