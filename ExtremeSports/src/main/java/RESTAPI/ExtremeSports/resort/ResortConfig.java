package RESTAPI.ExtremeSports.resort;

import RESTAPI.ExtremeSports.country.Country;
import RESTAPI.ExtremeSports.region.Region;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ResortConfig {
    @Bean
    CommandLineRunner resortCLR(ResortRepository resortRepository) {
        return args -> {
            Resort predeal = new Resort(
                    "Predeal",
                    new Region(
                            2L,
                            "Prahova",
                            new Country(1L, "Romania"))
            );

            Resort azuga = new Resort(
                    "Azuga",
                    new Region(
                            2L,
                            "Prahova",
                            new Country(1L, "Romania"))
            );

            Resort busteni = new Resort(
                    "Busteni",
                    new Region(
                            2L,
                            "Prahova",
                            new Country(1L, "Romania"))
            );

            resortRepository.saveAll(List.of(predeal, azuga, busteni));
        };
    }
}