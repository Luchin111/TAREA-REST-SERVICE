package com.example.TAREA_REST;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(PumakatariRepository repository) {
        return args -> {
            repository.save(new Pumakatari("3466 RAS", "ACHUMANI-SAN PEDRO"));
            repository.save(new Pumakatari("5123 SSA", "LLOJETA- 6 DE AGOSTO"));
        };
    }
}