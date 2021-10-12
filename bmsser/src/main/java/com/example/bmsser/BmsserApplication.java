package com.example.bmsser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.example.bmsser.repository")
@EnableTransactionManagement
public class BmsserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmsserApplication.class, args);
    }

}
