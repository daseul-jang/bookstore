package com.bookstore.backend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@EnableJpaAuditing
@SpringBootApplication
public class BackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);

        LocalDate localDate = LocalDate.now();
        String formatDate = localDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        log.info("local date : " + formatDate);
    }

}
