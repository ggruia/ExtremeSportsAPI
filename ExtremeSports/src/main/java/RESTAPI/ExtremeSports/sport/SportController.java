package RESTAPI.ExtremeSports.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/sport")
public class SportController {

    private final SportService sportService;

    @Autowired
    public SportController(SportService sportService) {
        this.sportService = sportService;
    }


    @GetMapping()
    public List<Sport> getAllSports() { return sportService.getAll(); }

    @GetMapping(path = "{sportId}")
    public Sport getSportById(@PathVariable("sportId") Long sportId) {
        return sportService.getById(sportId);
    }

    @PostMapping
    public void addSport(@RequestBody Sport sport) {
        sportService.add(sport);
    }

    @DeleteMapping(path="{sportId}")
    public void deleteSportById(@PathVariable("sportId") Long sportId) {
        sportService.delete(sportId);
    }

    @PutMapping
    public void updateSport(@RequestBody Sport sport){
        sportService.update(sport);
    }
}
