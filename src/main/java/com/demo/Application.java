package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author JHYe
 * @date 2024/4/8
 */
@SpringBootApplication
@MapperScan(basePackages = "com.demo.mapper")
public class Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        System.out.println("springboot-base系统启动成功(个人使用)");

    }
}
