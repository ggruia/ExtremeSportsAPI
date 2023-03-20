package RESTAPI.ExtremeSports.resort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/resort")
public class ResortController {

    private final ResortService resortService;

    @Autowired
    public ResortController(ResortService resortService) {
        this.resortService = resortService;
    }


    @GetMapping(path = "{resortId}")
    public Resort getResortById(@PathVariable("resortId") Long resortId) {
        return resortService.getById(resortId);
    }

    @GetMapping
    public List<Resort> getAllResorts() {
        return resortService.getAll();
    }

    @PostMapping
    public void addResort(Resort resort) {
        resortService.add(resort);
    }

    @DeleteMapping(path = "{resortId}")
    public void deleteResort(@PathVariable("resortId") Long resortId) {
        resortService.delete(resortId);
    }
}
