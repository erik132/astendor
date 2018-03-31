package erik.soekov.astendor.maps.models;

import javax.persistence.*;

@Entity
@Table(name="maptiles")
public class MapTile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer x;
    private Integer y;
    private String name;

    @ManyToOne
    @JoinColumn(name="map_id", nullable = false)
    private WorldMap worldMap;

    @ManyToOne
    @JoinColumn(name="terrain_id", nullable=false)
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name="race_id", nullable = false)
    private Race race;

    public MapTile() {
    }

    public MapTile(Integer x, Integer y, String name, WorldMap worldMap, Terrain terrain, Race race) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.worldMap = worldMap;
        this.terrain = terrain;
        this.race = race;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorldMap getWorldMap() {
        return worldMap;
    }

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
