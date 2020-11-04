package com.github.eljaiek.playground;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    CommandLineRunner registerZonesDataRunner(EntityManager entityManager, TransactionTemplate transactionTemplate) {
//        return args -> transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//            @Override
//            protected void doInTransactionWithoutResult(TransactionStatus status) {
//                Stream.of("AFRICA", "EUROPE")
//                        .map(GeographicZone::new)
//                        .forEach(entityManager::persist);
//            }
//        });
//    }

    @Bean
    CommandLineRunner registerZonesDataRunner(GeographicZoneRepository repository) {
        return args -> Stream.of("AFRICA", "EUROPE")
                .map(GeographicZone::new)
                .forEach(repository::save);
    }
}
