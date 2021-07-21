package com.framework;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = { "com.framework.modules.*.dao"})
public class AdminApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(AdminApplication.class);

	public static void main(String[] args) {
		try {
			SpringApplication.run(AdminApplication.class, args);

		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminApplication.class);
	}
}
