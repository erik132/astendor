package erik.soekov.astendor.items.dtos;

import erik.soekov.astendor.items.models.Blueprint;
import erik.soekov.astendor.items.models.Item;

import java.util.ArrayList;
import java.util.List;

public class BlueprintDto {

    private Integer id;
    private String name;

    private Item output;

    private List<ComponentDto> components;

    public BlueprintDto() {
    }

    public BlueprintDto(Blueprint blueprint){
        this.id = blueprint.getId();
        this.name = blueprint.getName();
        this.output = blueprint.getOutputItem();
        this.components = new ArrayList<>();
        blueprint.getComponents().forEach(component -> {
            this.components.add(new ComponentDto(component));
        });
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item getOutput() {
        return output;
    }

    public void setOutput(Item output) {
        this.output = output;
    }

    public List<ComponentDto> getComponents() {
        return components;
    }

    public void setComponents(List<ComponentDto> components) {
        this.components = components;
    }
}
