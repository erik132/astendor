package erik.soekov.astendor.maps.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="maps")
public class WorldMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    private Integer xdim;
    private Integer ydim;

    @OneToMany(mappedBy = "worldMap", cascade = CascadeType.ALL)
    @OrderBy("y,x ASC")
    private Set<MapTile> tiles;

    public WorldMap() {
    }

    public WorldMap(String name, String description, Integer xdim, Integer ydim, Set<MapTile> tiles) {
        this.name = name;
        this.description = description;
        this.xdim = xdim;
        this.ydim = ydim;
        this.tiles = tiles;
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

    public Set<MapTile> getTiles() {
        return tiles;
    }

    public void setTiles(Set<MapTile> tiles) {
        this.tiles = tiles;
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

    public List<List<MapTile>> xyTiles(){
        List<List<MapTile>> result = new ArrayList<>();
        Set<MapTile> tiles = this.getTiles();

        Integer i = 0,u = 0;

        for(i=0; i< this.getXdim(); i++){
            result.add(new ArrayList<>());
            
        }

        tiles.forEach(tile ->{
            result.get(tile.getX()).add(tile.getY(),tile);
        });


        return result;
    }
}