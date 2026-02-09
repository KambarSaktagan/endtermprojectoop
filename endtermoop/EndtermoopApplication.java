package com.example.endtermoop;

import com.example.endtermoop.model.EconomyCar;
import com.example.endtermoop.utils.ReflectionUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EndtermoopApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndtermoopApplication.class, args);
    }

    @Bean
    CommandLineRunner reflectionDemo() {
        return args -> ReflectionUtils.inspectClass(EconomyCar.class);
    }
}
