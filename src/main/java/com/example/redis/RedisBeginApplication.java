package com.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisBeginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisBeginApplication.class, args);
	}

}
