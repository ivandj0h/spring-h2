package com.ivandjoh.springh2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    // RestTemplate bean configuration
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}