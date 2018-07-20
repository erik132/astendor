package erik.soekov.astendor.items.models;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class BlueprintComponentIdentity implements Serializable {

    @NotNull
    @Column(name = "item_id")
    private Integer itemId;

    @NotNull
    @Column(name = "blueprint_id")
    private Integer blueprintId;

    public BlueprintComponentIdentity() {
    }

    public BlueprintComponentIdentity(@NotNull Integer itemId, @NotNull Integer blueprintId) {
        this.itemId = itemId;
        this.blueprintId = blueprintId;
    }

    @Override
    public int hashCode() {
        return this.blueprintId*10000 + this.itemId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        BlueprintComponentIdentity target = (BlueprintComponentIdentity) obj;

        if(!this.itemId.equals(target.getItemId()) || !this.blueprintId.equals(target.getBlueprintId())){
            return false;
        }

        return true;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBlueprintId() {
        return blueprintId;
    }

    public void setBlueprintId(Integer blueprintId) {
        this.blueprintId = blueprintId;
    }
}
