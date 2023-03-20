package RESTAPI.ExtremeSports.sport;

import javax.persistence.*;

@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //<editor-fold desc="Getters & Setters">
    public Sport() {
    }

    public Sport(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Sport(String name) {
        this.name = name;
    }
    //</editor-fold>

    //<editor-fold desc="Constructors">
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
    //</editor-fold>
}
