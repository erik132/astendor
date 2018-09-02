package erik.soekov.astendor.worlds.models;

import erik.soekov.astendor.items.models.Item;

import javax.persistence.*;

@Entity
@Table(name = "world_harvests")
public class WorldHarvest {

    @EmbeddedId
    private WorldHarvestIdentity id;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "harvest_meter")
    private Double harvestMeter;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @MapsId("tileId")
    @JoinColumn(name = "tile_id", nullable = false)
    private WorldTile worldTile;

    public WorldHarvest() {
    }

    public WorldHarvestIdentity getId() {
        return id;
    }

    public void setId(WorldHarvestIdentity id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getHarvestMeter() {
        return harvestMeter;
    }

    public void setHarvestMeter(Double harvestMeter) {
        this.harvestMeter = harvestMeter;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public WorldTile getWorldTile() {
        return worldTile;
    }

    public void setWorldTile(WorldTile worldTile) {
        this.worldTile = worldTile;
    }
}
