package RESTAPI.ExtremeSports.filter;

import RESTAPI.ExtremeSports.country.CountryService;
import RESTAPI.ExtremeSports.region.RegionService;
import RESTAPI.ExtremeSports.resort.ResortService;
import RESTAPI.ExtremeSports.sport.SportService;
import RESTAPI.ExtremeSports.sport_resort.SportResort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/filter")
public class FilterController {
    private final SportService sportService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final ResortService resortService;
    private final FilterService filterService;

    @Autowired
    public FilterController(
            SportService sportService,
            CountryService countryService,
            RegionService regionService,
            ResortService resortService,
            FilterService filterService) {

        this.sportService = sportService;
        this.countryService = countryService;
        this.regionService = regionService;
        this.resortService = resortService;
        this.filterService = filterService;
    }

    @GetMapping
    public List<SportResort> filterQuery(
            @RequestParam(value = "sport", required = false) List<Long> sports,
            @RequestParam(value = "location", required = false) List<Long> locations,
            @RequestParam(value = "start", required = false) Date startDate,
            @RequestParam(value = "end", required = false) Date endDate){

        return filterService.getAll(sports, locations, startDate, endDate);
    }
}
