package erik.soekov.astendor.general;

import erik.soekov.astendor.worlds.models.World;
import erik.soekov.astendor.worlds.services.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private WorldService worldService;

    @RequestMapping("/")
    public String landingPage(){
        return "landingPage";
    }

    @RequestMapping("/astendor/worldlist")
    public String showWorldList(Model model){
        Iterable<World> worlds = this.worldService.getActiveWorlds();
        model.addAttribute("worlds", worlds);
        return "astendor/worldList";
    }

}
