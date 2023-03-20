package RESTAPI.ExtremeSports.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SportService {

    private final SportRepository sportRepository;

    @Autowired
    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public List<Sport> getAll() {
        return sportRepository.findAll();
    }

    public Sport getById(Long sportId) {
        return sportRepository
                .findById(sportId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Sport with ID '%d' does not exist!", sportId)));
    }

    public void add(Sport sp) {
        Sport sport = sportRepository
                .findByName(sp.getName())
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Sport with name '%s' is already registered!", sp.getName())));

        sportRepository.save(sport);
    }

    public void delete(Long sportId) {
        boolean exists = sportRepository.existsById(sportId);
        if (!exists) {
            throw new IllegalStateException(String.format("Sport with ID '%d' does not exist!", sportId));
        }
        sportRepository.deleteById(sportId);
    }

    @Transactional
    public void update(Sport sport) {
        boolean exists = sportRepository.existsById(sport.getId());
        if (!exists) {
            throw new IllegalStateException(String.format("Sport with ID '%d' does not exist!", sport.getId()));
        }
        sportRepository.save(sport);
    }
}
