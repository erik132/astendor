package erik.soekov.astendor.maps;

import erik.soekov.astendor.maps.services.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MapController {

    @Autowired
    private TileService tileService;

    @RequestMapping("/map")
    public String mapview(Model model){
        model.addAttribute("maptiles", tileService.getTiles());
        return "main/mapview";
    }
}
