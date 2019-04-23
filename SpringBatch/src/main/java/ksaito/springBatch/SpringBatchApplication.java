package ksaito.springBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestSpringBatchApplication.class, args);
    }

}
