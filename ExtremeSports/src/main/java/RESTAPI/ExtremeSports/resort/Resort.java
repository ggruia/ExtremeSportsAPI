package RESTAPI.ExtremeSports.resort;

import RESTAPI.ExtremeSports.region.Region;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class Resort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.REMOVE, optional = false)
    @JoinColumn(name = "regionId", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Region region;

    //<editor-fold desc="Constructors">
    public Resort() {
    }

    public Resort(Long id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public Resort(String name, Region region) {
        this.name = name;
        this.region = region;
    }
    //</editor-fold>

    //<editor-fold desc="Getters & Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    //</editor-fold>
}