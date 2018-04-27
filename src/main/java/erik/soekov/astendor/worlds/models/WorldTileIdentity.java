package erik.soekov.astendor.worlds.models;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class WorldTileIdentity implements Serializable {

    @NotNull
    @Column(name = "world_id")
    private Integer worldId;
    @NotNull
    @Column(name = "x")
    private Integer x;
    @NotNull
    @Column(name = "y")
    private Integer y;

    public WorldTileIdentity() {
    }

    public WorldTileIdentity(@NotNull Integer worldId, @NotNull Integer x, @NotNull Integer y) {
        this.worldId = worldId;
        this.x = x;
        this.y = y;
    }

    public Integer getWorldId() {
        return worldId;
    }

    public void setWorldId(Integer worldId) {
        this.worldId = worldId;
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

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        WorldTileIdentity target = (WorldTileIdentity) obj;

        if(!this.worldId.equals(target.worldId)) return false;
        if(!this.x.equals(target.x)) return false;

        return this.y.equals(target.y);
    }

    @Override
    public int hashCode() {
        int result = worldId.hashCode();
        result = 31 * result + x.hashCode() + y.hashCode();
        return result;
    }

}
