package RESTAPI.ExtremeSports.sport_resort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportResortRepository extends JpaRepository<SportResort, Long> {

    @Query("SELECT sr FROM SportResort sr WHERE sr.resort.id = :resortId")
    public List<SportResort> getSportResortsByResort(Long resortId);

    @Query("SELECT sr FROM SportResort sr WHERE sr.sport.id = :sportId")
    public List<SportResort> getSportResortsBySport(Long sportId);
}
