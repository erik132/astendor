package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.maps.models.MapTile;
import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.maps.models.Terrain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "world_tiles")
public class WorldTile {

    @Id
    private Integer id;

    @Column(name = "x")
    private Integer x;

    @Column(name = "y")
    private Integer y;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="terrain_id", nullable=false)
    private Terrain terrain;

    @ManyToOne
    @JoinColumn(name="race_id", nullable = false)
    private Race race;

    @ManyToOne
    @MapsId("worldId")
    @JoinColumn(name="world_id", nullable = false)
    private World world;

    @Column(name="owner_warlord")
    private Integer ownerWarlord;

    @OneToMany(mappedBy = "worldTile", cascade = CascadeType.ALL)
    private List<WorldHarvest> harvests;

    public WorldTile() {
    }

    public WorldTile(MapTile mapTile, World world){
        this.x = mapTile.getX();
        this.y = mapTile.getY();
        this.name = mapTile.getName();
        this.terrain = mapTile.getTerrain();
        this.race = mapTile.getRace();
        this.world = world;
    }

    public List<WorldHarvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<WorldHarvest> harvests) {
        this.harvests = harvests;
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

    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Integer getOwnerWarlord() {
        return ownerWarlord;
    }

    public void setOwnerWarlord(Integer ownerWarlord) {
        this.ownerWarlord = ownerWarlord;
    }
}
