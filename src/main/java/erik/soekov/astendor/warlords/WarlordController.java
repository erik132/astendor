package erik.soekov.astendor.warlords;

import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.orders.services.RaceService;
import erik.soekov.astendor.worlds.models.WorldPrimitive;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;

@Controller
@RequestMapping("/warlords")
public class WarlordController {

    @Autowired
    private WorldService worldService;

    @Autowired
    private RaceService raceService;

    @RequestMapping(method = RequestMethod.GET,value = "/create/{worldId}")
    public String showWarlordCreation(@PathVariable Integer worldId,Model model){
        return this.loadWarlordCreation(worldId,model);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/{worldId}")
    public String createWarlord(@PathVariable Integer worldId,Model model){
        return this.loadWarlordCreation(worldId,model);
    }

    private String loadWarlordCreation(Integer worldId, Model model){
        WorldPrimitive world = this.worldService.getWorldPrimitive(worldId);
        List<Race> races = this.raceService.getAllRaces();
        model.addAttribute("world", world);
        model.addAttribute("races", races);
        return "/warlords/createWarlord";
    }
}
