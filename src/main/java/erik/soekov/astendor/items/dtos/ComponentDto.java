package erik.soekov.astendor.items.dtos;

import erik.soekov.astendor.items.models.BlueprintComponent;
import erik.soekov.astendor.items.models.Item;

public class ComponentDto {

    private Item item;
    private Integer amount;

    public ComponentDto() {
    }

    public ComponentDto(BlueprintComponent component){
        this.item = component.getItem();
        this.amount = component.getAmount();
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
}
