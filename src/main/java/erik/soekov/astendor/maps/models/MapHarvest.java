package erik.soekov.astendor.maps.models;

import erik.soekov.astendor.items.models.Item;

import javax.persistence.*;

@Entity
@Table(name = "map_harvests")
public class MapHarvest {

    @EmbeddedId
    private MapHarvestIdentity id;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @MapsId("tileId")
    @JoinColumn(name = "tile_id", nullable = false)
    private MapTile mapTile;

    public MapHarvest() {
    }

    public MapHarvestIdentity getId() {
        return id;
    }

    public void setId(MapHarvestIdentity id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getItemId(){
        return this.id.getItemId();
    }

    public Integer getTileId(){
        return this.id.getTileId();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public MapTile getMapTile() {
        return mapTile;
    }

    public void setMapTile(MapTile mapTile) {
        this.mapTile = mapTile;
    }
}
