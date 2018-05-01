package erik.soekov.astendor.worlds.models;

import javax.persistence.*;

@Entity
@Table(name = "worlds")
public class WorldPrimitive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "turn_nr")
    private Integer turnNr;

    public WorldPrimitive() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurnNr() {
        return turnNr;
    }

    public void setTurnNr(Integer turnNr) {
        this.turnNr = turnNr;
    }
}
