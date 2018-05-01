package erik.soekov.astendor.warlords;

import erik.soekov.astendor.general.MainController;
import erik.soekov.astendor.general.constants.LinkLib;
import erik.soekov.astendor.maps.models.Race;
import erik.soekov.astendor.maps.services.RaceService;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.services.AstendorUserService;
import erik.soekov.astendor.warlords.dtos.WarlordDTO;
import erik.soekov.astendor.warlords.exceptions.WarlordAlreadyExistsException;
import erik.soekov.astendor.warlords.services.WarlordService;
import erik.soekov.astendor.worlds.models.WorldPrimitive;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/warlords")
public class WarlordController {

    @Autowired
    private WarlordService warlordService;

    @Autowired
    private WorldService worldService;

    @Autowired
    private RaceService raceService;

    @Autowired
    private AstendorUserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/create/{worldId}")
    public String showWarlordCreation(@PathVariable Integer worldId,Model model){
        model.addAttribute("warlord", new WarlordDTO());
        return this.loadWarlordCreation(worldId,model);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/{worldId}")
    public String createWarlord(@Valid WarlordDTO warlordDTO, @PathVariable Integer worldId, Authentication authentication, Model model){
        User user =  this.userService.findByUsername(authentication.getName());

        try{
            this.warlordService.createWarlord(warlordDTO,user,worldId);
        }catch (WarlordAlreadyExistsException wae) {
            return MainController.goError(wae.getMessage(),
                    LinkLib.worldList,
                    model);
        }
        model.addAttribute("warlord", warlordDTO);
        model.addAttribute("announcement", "warlord created successfully");
        return this.loadWarlordCreation(worldId,model);
    }

    private String loadWarlordCreation(Integer worldId, Model model){
        WorldPrimitive world = this.worldService.getWorldPrimitive(worldId);
        List<Race> races = this.raceService.getAllRaces();
        model.addAttribute("linkLib", new LinkLib());
        model.addAttribute("world", world);
        model.addAttribute("races", races);
        return "/warlords/createWarlord";
    }
}
