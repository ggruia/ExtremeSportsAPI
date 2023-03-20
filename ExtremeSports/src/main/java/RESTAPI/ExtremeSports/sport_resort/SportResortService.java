package RESTAPI.ExtremeSports.sport_resort;

import RESTAPI.ExtremeSports.resort.Resort;
import RESTAPI.ExtremeSports.resort.ResortService;
import RESTAPI.ExtremeSports.sport.Sport;
import RESTAPI.ExtremeSports.sport.SportService;
import RESTAPI.ExtremeSports.sport_resort.dto.SportResortDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportResortService {

    private final SportResortRepository sportResortRepository;
    private final SportService sportService;
    private final ResortService resortService;

    @Autowired
    public SportResortService (
            SportResortRepository sportResortRepository,
            SportService sportService,
            ResortService resortService) {
        this.sportResortRepository = sportResortRepository;
        this.sportService = sportService;
        this.resortService = resortService;
    }

    public SportResortDTO getById(Long sportResortId) {
        return sportResortRepository
                .findById(sportResortId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("SportResort with ID '%d' does not exist!", sportResortId)));
    }

    public List<SportResortDTO> getAll() {
        return sportResortRepository.findAll();
    }

    public void add(SportResortDTO srm) {
        SportResort sportResort = new SportResort(
                sportService.getById(srm.getSportId()),
                resortService.getById(srm.getResortId()),
                srm.getCost(),
                srm.getStartDate(),
                srm.getEndDate());
        sportResortRepository.save(sportResort);
    }

    public void delete(Long sportResortId) {
        if(!sportResortRepository.existsById(sportResortId)) {
            throw new IllegalStateException(
                    String.format("SportResort with ID '%d' does not exist!", sportResortId));
        }
        sportResortRepository.deleteById(sportResortId);
    }

    @Transactional
    public void update(Long sportResortId, Float cost, Date startDate, Date endDate) {
        SportResort sportResort = sportResortRepository
                .findById(sportResortId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("SportResort with ID '%d' does not exist!", sportResortId)));

        sportResort.setCost(cost);
        sportResort.setStartDate(startDate);
        sportResort.setEndDate(endDate);

        sportResortRepository.save(sportResort);
    }

    public List<Sport> getSportsByResort(Long resortId) {
        return sportResortRepository
                .getSportResortsByResort(resortId)
                .stream()
                .map(SportResort::getSport)
                .collect(Collectors.toList());
    }

    public List<Resort> getResortsBySport(Long sportId) {
        return sportResortRepository
                .getSportResortsBySport(sportId)
                .stream()
                .map(SportResort::getResort)
                .collect(Collectors.toList());
    }
}
