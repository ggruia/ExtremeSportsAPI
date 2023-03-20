package RESTAPI.ExtremeSports.region;

import RESTAPI.ExtremeSports.country.Country;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RegionConfig {
    @Bean
    CommandLineRunner regionCLR(RegionRepository regionRepository) {
        return args -> {
            Region brasov = new Region(
                    "Brasov",
                    new Country(1L, "Romania")
            );

            Region prahova = new Region(
                    "Prahova",
                    new Country(1L, "Romania")
            );

            Region cluj = new Region(
                    "Cluj",
                    new Country(1L, "Romania")
            );

            regionRepository.saveAll(List.of(brasov, prahova, cluj));
        };
    }
}
