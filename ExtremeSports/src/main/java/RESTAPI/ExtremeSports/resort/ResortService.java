package RESTAPI.ExtremeSports.resort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResortService {

    public final ResortRepository resortRepository;

    @Autowired
    public ResortService(ResortRepository resortRepository) {
        this.resortRepository = resortRepository;
    }

    public Resort getById(Long resortId) {
        return resortRepository
                .findById(resortId)
                .orElseThrow(() -> new IllegalStateException(
                        String.format("Resort with ID '%d' does not exist!", resortId)));
    }

    public List<Resort> getAll() {
        return resortRepository.findAll();
    }

    public void add(Resort resort) {
    }

    public void delete(Long resortId) {
    }
}
