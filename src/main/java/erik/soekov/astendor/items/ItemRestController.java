package erik.soekov.astendor.items;

import erik.soekov.astendor.items.models.Blueprint;
import erik.soekov.astendor.items.models.Item;
import erik.soekov.astendor.items.services.BlueprintService;
import erik.soekov.astendor.items.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemRestController {

    @Autowired
    private BlueprintService blueprintService;

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "all-items")
    public List<Item> getItems(){
        return this.itemService.getItems();
    }

    @RequestMapping(value = "all-blueprints")
    public List<Blueprint> getBlueprints(){
        return this.blueprintService.getBlueprints();
    }
}
