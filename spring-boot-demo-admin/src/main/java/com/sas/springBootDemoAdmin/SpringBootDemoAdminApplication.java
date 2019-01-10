package com.sas.springBootDemoAdmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//大坑
//@SpringBootApplication
//@EnableAdminServer

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class SpringBootDemoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoAdminApplication.class, args);
    }

}

