package com.project.song;

import com.project.song.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter(){
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();

		filterRegistration.setFilter(new JwtFilter());
		filterRegistration.addUrlPatterns("/api/v1/*");

		return filterRegistration;
	}

}
