package RESTAPI.ExtremeSports.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/region")
public class RegionController {

    private final RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping(path = "{regionId}")
    public Region getRegionById(@PathVariable("regionId") Long regionId) {
        return regionService.getRegionById(regionId);
    }

    @PostMapping(path = "add")
    public void addRegion(@RequestBody RegionCountryModel regionCountryModel) {
        regionService.addRegion(regionCountryModel);
    }

    @PostMapping(path = "add/{countryId}")
    public void addRegionToCountry(@PathVariable("countryId") Long countryId, @RequestBody Region region) {
        regionService.addRegionToCountry(countryId, region);
    }
}
