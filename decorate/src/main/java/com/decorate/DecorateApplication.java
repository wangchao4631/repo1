package com.decorate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.decorate.dao")
public class DecorateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DecorateApplication.class, args);
    }

}
