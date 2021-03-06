package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.maps.models.MapTile;
import erik.soekov.astendor.maps.models.WorldMap;
import erik.soekov.astendor.maps.models.WorldMapPrimitive;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.worlds.dto.WorldDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="worlds")
public class World {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "turn_nr")
    private Integer turnNr;

    @Column(name = "harvest_multi")
    private Float harvestMulti;

    @ManyToOne
    @JoinColumn(name = "map_id", nullable = false)
    private WorldMapPrimitive map;

    @OneToMany(mappedBy = "world", cascade = CascadeType.ALL)
    private Set<Warlord> warlords;

    @OneToMany(mappedBy = "world", cascade = CascadeType.ALL)
    @OrderBy("y,x ASC")
    private Set<WorldTile> tiles;

    public World() {
    }

    public World(WorldDTO worldDTO,WorldMapPrimitive minMap, Set<MapTile> tiles){
        this.name = worldDTO.getName();
        this.turnNr = 0;
        this.map = minMap;
        this.warlords = new HashSet<>();
        this.tiles = new HashSet<>();
        this.harvestMulti = worldDTO.getHarvestMulti();
        tiles.forEach(mapTile -> {
            this.tiles.add(new WorldTile(mapTile, this));
        });
    }

    public World(String name, WorldMapPrimitive map) {
        this.name = name;
        this.map = map;
    }

    public List<List<WorldTile>> yxTiles(){
        List<List<WorldTile>> result = new ArrayList<>();

        for(Integer i=0; i< this.getMap().getYdim(); i++){
            result.add(new ArrayList<>());
        }

        this.getTiles().forEach(tile ->{
            result.get(tile.getY()).add(tile.getX(),tile);
        });

        return result;
    }

    public boolean checkForWarlord(User user){
        if(this.findWarlord(user) != null){
            return true;
        }
        return false;
    }

    public Warlord findWarlord(User user){
        for(Warlord warlord : this.getWarlords()){
            if(warlord.getUserId().equals(user.getId())){
                return warlord;
            }
        }
        return null;
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

    public WorldMapPrimitive getMap() {
        return map;
    }

    public void setMap(WorldMapPrimitive map) {
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

    public Set<WorldTile> getTiles() {
        return tiles;
    }

    public void setTiles(Set<WorldTile> tiles) {
        this.tiles = tiles;
    }

    public Float getHarvestMulti() {
        return harvestMulti;
    }

    public void setHarvestMulti(Float harvestMulti) {
        this.harvestMulti = harvestMulti;
    }
}
