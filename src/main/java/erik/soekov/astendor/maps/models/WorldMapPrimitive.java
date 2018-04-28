package erik.soekov.astendor.maps.models;

import javax.persistence.*;

/**
 * All the data that does not change when converting a map to a world.
 */
@Entity
@Table(name="maps")
public class WorldMapPrimitive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    private Integer xdim;
    private Integer ydim;
    private String mapFile;

    public WorldMapPrimitive() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getXdim() {
        return xdim;
    }

    public void setXdim(Integer xdim) {
        this.xdim = xdim;
    }

    public Integer getYdim() {
        return ydim;
    }

    public void setYdim(Integer ydim) {
        this.ydim = ydim;
    }

    public String getMapFile() {
        return mapFile;
    }

    public void setMapFile(String mapFile) {
        this.mapFile = mapFile;
    }
}
