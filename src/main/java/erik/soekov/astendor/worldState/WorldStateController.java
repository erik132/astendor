package erik.soekov.astendor.worldState;

import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.services.AstendorUserService;
import erik.soekov.astendor.warlords.dtos.WarlordDTO;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.services.WarlordService;
import erik.soekov.astendor.worldState.models.WorldState;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/worldstate")
public class WorldStateController {

    @Autowired
    private WorldService worldService;

    @Autowired
    private AstendorUserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/get/{worldId}")
    public WorldState getWorldState(@PathVariable Integer worldId, Authentication authentication){
        User user = this.userService.findByAuthentication(authentication);
        World world = this.worldService.getWorld(worldId);
        WorldState worldState = new WorldState();

        Warlord warlord = world.findWarlord(user);

        if(warlord == null){
            worldState.setErrorMsg("User does not have warlord in this world");
        }else {
            worldState.setWarlord(new WarlordDTO(warlord));
        }
        return worldState;
    }
}
