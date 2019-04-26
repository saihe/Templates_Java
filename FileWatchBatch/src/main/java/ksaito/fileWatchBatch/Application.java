package ksaito.fileWatchBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@PropertySource("file:${properties.path.application}")
@PropertySource("file:${properties.path.message}")
@PropertySource("file:${properties.path.logging}")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
