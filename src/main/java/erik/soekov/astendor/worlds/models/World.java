package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.maps.models.WorldMap;

import javax.persistence.*;

@Entity
@Table(name="worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private WorldMap map;

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
}
