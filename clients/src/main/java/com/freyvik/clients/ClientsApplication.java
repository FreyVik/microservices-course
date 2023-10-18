package com.freyvik.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executor;

@EnableAsync
@SpringBootApplication
public class ClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientsApplication.class, args);
	}

	@Bean
	public RestTemplate template() {

		BasicAuthenticationInterceptor interceptor;
		interceptor = new BasicAuthenticationInterceptor("admin", "admin");

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(interceptor);

		return restTemplate;
	}

	@Bean
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
	}
}
