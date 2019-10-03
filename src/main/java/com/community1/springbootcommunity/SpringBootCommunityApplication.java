package com.community1.springbootcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/*@ComponentScan(value = "com.community1")*/
public class SpringBootCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommunityApplication.class, args);
    }

}
