package RESTAPI.ExtremeSports.country;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/countries")
public class CountryController {

    private final CountryService countryService;


    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAll();
    }

    @GetMapping(path = "{countryId}")
    public Optional<Country> getCountryById(@PathVariable("countryId") Long countryId) {
        return countryService.getCountryById(countryId);
    }
//
//    @PostMapping
//    public void addCountry() {
//
//    }
//
//    @DeleteMapping
//    public void deleteCountry() {
//
//    }
//
//    @PutMapping
//    public void updateCountry() {
//
//    }
}
