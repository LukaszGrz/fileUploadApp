package com.example.springbootfileuploadmysql;

import com.example.springbootfileuploadmysql.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SpringbootfileuploadmysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootfileuploadmysqlApplication.class, args);
	}
}
