package erik.soekov.astendor.worldState;

import erik.soekov.astendor.warlords.model.StrippedWarlord;
import erik.soekov.astendor.warlords.services.WarlordService;
import erik.soekov.astendor.worldState.models.WorldState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worldstate")
public class WorldStateController {

    @Autowired
    private WarlordService warlordService;

    @RequestMapping(method = RequestMethod.POST, value = "/get/{warlordid}")
    public WorldState getWorldState(@PathVariable Integer warlordid){
        return new WorldState(new StrippedWarlord(this.warlordService.getWarlord(warlordid)));
    }
}
