package erik.soekov.astendor.items.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="blueprints")
public class Blueprint {

    @Id
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name ="output_item_id", nullable = false)
    private Item outputItem;

    @OneToMany(mappedBy = "blueprint", cascade = CascadeType.ALL)
    private Set<BlueprintComponent> components;

    public Blueprint() {
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Blueprint target = (Blueprint) obj;
        if(target.getId().equals(this.id)){
            return true;
        }
        return false;
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

    public Item getOutputItem() {
        return outputItem;
    }

    public void setOutputItem(Item outputItem) {
        this.outputItem = outputItem;
    }

    public Set<BlueprintComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<BlueprintComponent> components) {
        this.components = components;
    }
}
