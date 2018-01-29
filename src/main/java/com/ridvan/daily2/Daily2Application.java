package com.ridvan.daily2;

import com.ridvan.daily2.controller.HomeController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication

public class Daily2Application {
    public static void main(String[] args) {
        SpringApplication.run(Daily2Application.class, args);
    }

    @Bean
    public CommandLineRunner homeControllerBeanCheck (ApplicationContext ctx) {
        return args -> {
            ctx.getBean(HomeController.class);
        };
    }


}
