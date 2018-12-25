package com.shenya.sewage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shenya.sewage.dao")
public class SewageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SewageApplication.class, args);
    }
}
