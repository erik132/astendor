package erik.soekov.astendor.maps.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class MapHarvestIdentity implements Serializable {

    @NotNull
    @Column(name = "tile_id")
    private Integer tileId;

    @NotNull
    @Column(name = "item_id")
    private Integer itemId;

    public MapHarvestIdentity() {
    }

    public MapHarvestIdentity(@NotNull Integer tileId, @NotNull Integer itemId) {
        this.tileId = tileId;
        this.itemId = itemId;
    }

    public Integer getTileId() {
        return tileId;
    }

    public void setTileId(Integer tileId) {
        this.tileId = tileId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        MapHarvestIdentity target = (MapHarvestIdentity) obj;

        if(!this.tileId.equals(target.tileId)) return false;

        return this.itemId.equals(target.itemId);
    }

    @Override
    public int hashCode() {
        int result = tileId.hashCode();
        result = 31 * result + itemId.hashCode();
        return result;
    }
}
