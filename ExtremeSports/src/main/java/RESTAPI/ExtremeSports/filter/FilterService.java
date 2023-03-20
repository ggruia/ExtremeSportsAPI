package RESTAPI.ExtremeSports.filter;

import RESTAPI.ExtremeSports.sport_resort.SportResort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilterService {

    public List<SportResort> getAll(List<Long> sports, List<Long> locations, Date startDate, Date endDate) {
        return null;
    }
}
