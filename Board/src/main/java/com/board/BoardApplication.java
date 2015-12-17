package com.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.board.authorization.JwtFilter;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }
    
    @Bean
    public FilterRegistrationBean jwtFilter() {
    	final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    	registrationBean.setFilter(new JwtFilter());
    	registrationBean.addUrlPatterns("/api/*");
    	return registrationBean;
    }
}