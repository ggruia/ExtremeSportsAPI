package RESTAPI.ExtremeSports.sport_resort;

import RESTAPI.ExtremeSports.resort.Resort;
import RESTAPI.ExtremeSports.sport.Sport;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SportResort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "sportId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sport sport;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "resortId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Resort resort;

    private Float cost;
    private Date startDate;
    private Date endDate;

    //<editor-fold desc="Constructors">
    public SportResort() {
    }

    public SportResort(Long id, Sport sport, Resort resort, Float cost, Date startDate, Date endDate) {
        this.id = id;
        this.resort = resort;
        this.sport = sport;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SportResort(Sport sport, Resort resort, Float cost, Date startDate, Date endDate) {
        this.resort = resort;
        this.sport = sport;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    //</editor-fold>
}
