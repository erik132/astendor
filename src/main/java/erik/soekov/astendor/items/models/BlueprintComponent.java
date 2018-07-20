package erik.soekov.astendor.items.models;

import javax.persistence.*;

@Entity
@Table(name = "blueprint_components")
public class BlueprintComponent {

    @EmbeddedId
    private BlueprintComponentIdentity id;

    @ManyToOne
    @MapsId("blueprintId")
    @JoinColumn(name = "blueprint_id", nullable = false)
    private Blueprint blueprint;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @Column(name = "amount")
    private Integer amount;

    public BlueprintComponent() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Blueprint getBlueprint() {
        return blueprint;
    }

    public void setBlueprint(Blueprint blueprint) {
        this.blueprint = blueprint;
    }
}
