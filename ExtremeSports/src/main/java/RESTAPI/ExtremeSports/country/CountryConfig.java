package RESTAPI.ExtremeSports.country;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CountryConfig {

    @Bean
    CommandLineRunner countryCLR(CountryRepository countryRepository) {
        return args -> {
            Country romania = new Country(
                    "Romania"
            );

            Country belgium = new Country(
                    "Belgium"
            );

            Country usa = new Country(
                    "U.S.A."
            );

            countryRepository.saveAll(List.of(romania, belgium, usa));
        };
    }
}
