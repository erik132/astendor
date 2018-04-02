package erik.soekov.astendor.worlds;

import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WorldController {

    @Autowired
    private WorldService worldService;

    @RequestMapping(method = RequestMethod.GET,value = "/world/{id}")
    public String intoWorld(@PathVariable Integer id, Model model){
        World world = this.worldService.getWorld(id);
        model.addAttribute("worldmap",world.getMap());
        return "main/mapview";
    }
}
