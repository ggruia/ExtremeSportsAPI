package RESTAPI.ExtremeSports.sport_resort;

import RESTAPI.ExtremeSports.resort.Resort;
import RESTAPI.ExtremeSports.sport.Sport;
import RESTAPI.ExtremeSports.sport_resort.dto.SportResortDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/sport-resort")
public class SportResortController {

    private final SportResortService sportResortService;

    @Autowired
    public SportResortController(SportResortService sportResortService) {
        this.sportResortService = sportResortService;
    }

    @GetMapping(path = "{sportResortId}")
    public SportResortDTO getSportResortById(@PathVariable("sportResortId") Long sportResortId) {
        return sportResortService.getById(sportResortId);
    }

    @GetMapping
    public List<SportResortDTO> getAllSportResorts() {
        return sportResortService.getAll();
    }

    @PostMapping
    public void addSportResort(SportResortDTO sportResort) {
        sportResortService.add(sportResort);
    }

    @DeleteMapping(path = "{sportResortId}")
    public void deleteSportResort(@PathVariable("sportResortId") Long sportResortId) {
        sportResortService.delete(sportResortId);
    }

    @PutMapping(path = "{sportResortId}")
    public void updateSportResort(
            @PathVariable("sportResortId") Long sportResortId,
            @RequestParam(name = "cost", required = false) Float cost,
            @RequestParam(name = "start", required = false) Date startDate,
            @RequestParam(name = "end", required = false) Date endDate) {
        sportResortService.update(sportResortId, cost, startDate, endDate);
    }

    @GetMapping(path = "sports/{resortId}")
    public List<Sport> getSportsOfResort(@PathVariable("resortId") Long resortId) {
        return sportResortService.getSportsByResort(resortId);
    }

    @GetMapping(path = "resorts/{sportId}")
    public List<Resort> getResortsOfSport(@PathVariable("sportId") Long sportId) {
        return sportResortService.getResortsBySport(sportId);
    }
}
