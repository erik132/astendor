package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.warlords.model.Warlord;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer turnNr;

    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private WorldMap map;

    @OneToMany(mappedBy = "world", cascade = CascadeType.ALL)
    private Set<Warlord> warlords;

    public World() {
    }

    public World(String name, WorldMap map) {
        this.name = name;
        this.map = map;
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

    public WorldMap getMap() {
        return map;
    }

    public void setMap(WorldMap map) {
        this.map = map;
    }

    public Integer getTurnNr() {
        return turnNr;
    }

    public void setTurnNr(Integer turnNr) {
        this.turnNr = turnNr;
    }

    public void increaseTurn(){
        this.turnNr++;
    }

    public Set<Warlord> getWarlords() {
        return warlords;
    }

    public void setWarlords(Set<Warlord> warlords) {
        this.warlords = warlords;
    }
}
