package com.project.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.ToDoubleFunction;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients
@ComponentScan({"com.project"})
public class ServerApplication  {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

}
