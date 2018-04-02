package erik.soekov.astendor.warlords.model;

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
}
