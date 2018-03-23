package erik.soekov.astendor.maps.models;

import javax.persistence.*;

@Entity
@Table(name="maptiles")
public class MapTile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "map_id")
    private Integer mapId;
    private Integer x;
    private Integer y;
    private String name;

    public MapTile() {
    }

    public MapTile(Integer mapId, Integer x, Integer y, String name) {
        this.mapId = mapId;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public MapTile(Integer id, Integer mapId, Integer x, Integer y, String name) {
        this.mapId = mapId;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
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
}
