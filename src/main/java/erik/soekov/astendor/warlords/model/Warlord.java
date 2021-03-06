package erik.soekov.astendor.warlords.model;

import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.worlds.models.World;

import javax.persistence.*;

@Entity
@Table(name = "warlords")
public class Warlord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int x;
    private int y;

    @Column(name = "user_id")
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private Race race;

    @ManyToOne
    @JoinColumn(name = "world_id", nullable = false)
    private World world;

    public Warlord(int x, int y, World world) {
        this.x = x;
        this.y = y;
        this.world = world;
    }

    public Warlord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public boolean equals(Object obj) {
        Warlord other;
        try{
            other = (Warlord)obj;
        }catch (Exception e){
            return false;
        }

        if(other.getId() == this.getId()){
            return true;
        }
        return false;
    }
}
