package erik.soekov.astendor.worlds;

import erik.soekov.astendor.maps.services.MapService;
import erik.soekov.astendor.worlds.dto.WorldDTO;
import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/worlds")
public class WorldController {

    @Autowired
    private WorldService worldService;

    @Autowired
    private MapService mapService;

    @RequestMapping(method = RequestMethod.GET,value = "/get/{id}")
    public String intoWorld(@PathVariable Integer id, Model model){
        World world = this.worldService.getWorld(id);
        model.addAttribute("worldmap",world);
        return "main/mapview";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value="/create")
    public String showWorldCreationPage(Model model){
        model.addAttribute("worldDTO", new WorldDTO());
        model.addAttribute("maps", this.mapService.getPrimitiveMaps());
        return "admins/createWorld";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, value="/create")
    public String makeNewWorld(@Valid WorldDTO worldDTO, Model model){

        System.out.println(worldDTO.toString());
        this.worldService.createWorld(worldDTO);

        model.addAttribute("worldDTO", worldDTO);
        model.addAttribute("maps", this.mapService.getPrimitiveMaps());
        return "admins/createWorld";
    }
}
