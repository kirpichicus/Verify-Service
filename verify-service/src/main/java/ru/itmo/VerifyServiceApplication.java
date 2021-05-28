package ru.itmo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class VerifyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerifyServiceApplication.class, args);
    }
}
