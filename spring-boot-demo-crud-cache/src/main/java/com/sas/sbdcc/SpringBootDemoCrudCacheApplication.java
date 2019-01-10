package com.sas.sbdcc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.sas.sbdcc.dao")
public class SpringBootDemoCrudCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoCrudCacheApplication.class, args);
    }

}

