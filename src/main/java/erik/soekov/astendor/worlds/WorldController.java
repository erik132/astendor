package erik.soekov.astendor.worlds;

import erik.soekov.astendor.general.constants.LinkLib;
import erik.soekov.astendor.maps.services.MapService;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.services.AstendorUserDetailsService;
import erik.soekov.astendor.security.services.AstendorUserService;
import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.worlds.dto.WorldDTO;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/worlds")
public class WorldController {

    @Autowired
    private WorldService worldService;

    @Autowired
    private MapService mapService;

    @Autowired
    private AstendorUserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/get/{id}")
    public String intoWorld(@PathVariable Integer id, Authentication authentication, Model model){
        World world = this.worldService.getWorld(id);
        User user =  userService.findByUsername(authentication.getName());

        if(world.checkForWarlord(user)){
            model.addAttribute("worldmap",world);
            return "worlds/mapview";
        }
        return this.goError("You do not have a warlord in this world",
                LinkLib.worldList,
                model);


    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value="/create")
    public String showWorldCreationPage(Model model){
        model.addAttribute("worldDTO", new WorldDTO());
        model.addAttribute("maps", this.mapService.getPrimitiveMaps());
        model.addAttribute("linklib", new LinkLib());
        return "admins/createWorld";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value="/create")
    public String makeNewWorld(@Valid WorldDTO worldDTO, Model model){

        this.worldService.createWorld(worldDTO);

        model.addAttribute("worldDTO", worldDTO);
        model.addAttribute("maps", this.mapService.getPrimitiveMaps());
        model.addAttribute("linklib", new LinkLib());
        model.addAttribute("announcement", "New world created");
        return "admins/createWorld";
    }

    @RequestMapping("/worldlist")
    public String showWorldList(Authentication authentication,Model model){
        User user =  userService.findByUsername(authentication.getName());
        Iterable<World> worlds = this.worldService.getActiveWorlds();
        List<World> yourWorlds = new ArrayList<>();

        worlds.forEach(world -> {
            if(world.checkForWarlord(user)){
                yourWorlds.add(world);
            }
        });
        model.addAttribute("worlds", worlds);
        model.addAttribute("yourWorlds",yourWorlds);
        return LinkLib.worldList;
    }

    private String goError(String errorMsg, String returnPage, Model model){
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("returnPage", returnPage);
        return "/astendor/gameErrorPage";
    }


}
