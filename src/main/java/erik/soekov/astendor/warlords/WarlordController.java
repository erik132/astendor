package erik.soekov.astendor.warlords;

import erik.soekov.astendor.warlords.model.Warlord;
import erik.soekov.astendor.warlords.services.WarlordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warlord")
public class WarlordController {

    @Autowired
    private WarlordService warlordService;

    @RequestMapping("/reset/{id}")
    public String resetWarlordCoords(@PathVariable Integer id){
        Warlord warlord =this.warlordService.getWarlord(id);
        warlord.setX(1);
        warlord.setY(1);
        this.warlordService.setWarlord(warlord);
        return "warlord coords set to 1 1";
    }
}
