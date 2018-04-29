package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.maps.models.Terrain;


import javax.persistence.*;

@Entity
@Table(name = "world_tiles")
public class WorldTile {

    @EmbeddedId
    private WorldTileIdentity id;

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

    public WorldTile() {
    }

    public WorldTileIdentity getId() {
        return id;
    }

    public void setId(WorldTileIdentity id) {
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
        return this.id.getX();
    }

    public Integer getY(){
        return this.id.getY();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}