package RESTAPI.ExtremeSports.sport;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SportConfig {

    @Bean
    CommandLineRunner sportCLR(SportRepository sportRepository) {
        return args -> {
            Sport swimming = new Sport(
                    "Swimming"
            );

            Sport ski = new Sport(
                    "Ski"
            );

            Sport marathon = new Sport(
                    "Marathon"
            );

            sportRepository.saveAll(List.of(swimming, ski, marathon));
        };
    }
}
