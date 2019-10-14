package com.community1.springbootcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@MapperScan("com.community1.springbootcommunity.mapper")
@EnableScheduling
public class SpringBootCommunityApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityApplication.class, args);
    }

}
