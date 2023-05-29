package com.code;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@MapperScan("com.code.mapper")
public class SprintApplication {
    public static void main(String[] args) {

        SpringApplication.run(SprintApplication.class,args);
    }
}
