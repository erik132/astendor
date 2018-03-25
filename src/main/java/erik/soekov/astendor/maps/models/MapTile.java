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

    private Integer terrainId;

    public MapTile() {
    }

    public MapTile(Integer x, Integer y, String name, WorldMap worldMap, Integer terrainId) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.worldMap = worldMap;
        this.terrainId = terrainId;
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

    public Integer getTerrainId() {
        return terrainId;
    }

    public void setTerrainId(Integer terrainId) {
        this.terrainId = terrainId;
    }
}
