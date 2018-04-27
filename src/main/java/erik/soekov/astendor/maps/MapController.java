package erik.soekov.astendor.maps;

import erik.soekov.astendor.maps.services.MapService;
import erik.soekov.astendor.maps.services.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class MapController {

    @Autowired
    private MapService mapService;

    /*@RequestMapping("/map")
    public String mapview(Model model){
        model.addAttribute("worldmap", mapService.getMap(2));
        return "main/mapview";
    }*/
}
