package RESTAPI.ExtremeSports.region;

import RESTAPI.ExtremeSports.country.Country;
import RESTAPI.ExtremeSports.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

    private final RegionRepository regionRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository, CountryRepository countryRepository) {
        this.regionRepository = regionRepository;
        this.countryRepository = countryRepository;
    }

    public Region getRegionById(Long regionId) {
        return regionRepository
                .findById(regionId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Region with ID '%s' does not exist!", regionId)));
    }

    public void addRegion(RegionCountryModel regionCountry) {
        regionRepository
                .findByName(regionCountry.region.getName())
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Region with name '%s' is already registered!", regionCountry.region.getName())));

        Country country = countryRepository
                .findById(regionCountry.countryId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Country with ID '%d' does not exist!", regionCountry.countryId)));

        regionCountry.region.setCountry(country);
        regionRepository.save(regionCountry.region);
    }

    public void addRegionToCountry(Long countryId, Region region) {
        addRegion(new RegionCountryModel(region, countryId));
    }
}
