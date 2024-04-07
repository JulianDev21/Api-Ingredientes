package com.adso.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.adso.demo"})

public class DemoApplication {

    public static void main (String[] args) {

        System.out.println("Hola Julián esta es tu aplicación Demo");
        SpringApplication.run(DemoApplication.class, args);

    }
}
