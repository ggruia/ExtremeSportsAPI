package RESTAPI.ExtremeSports.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional<Country> getCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }

    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
