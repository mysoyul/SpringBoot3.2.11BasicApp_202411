package com.basic.myspringboot.config;

import com.basic.myspringboot.config.vo.CustomVO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdConfig {
    @Bean
    public CustomVO customVO() {
        return CustomVO.builder()
                .mode("운영 환경")
                .rate(0.8)
                .build();
    }
}