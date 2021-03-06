package erik.soekov.astendor.endturn;


import erik.soekov.astendor.endturn.services.EndturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endturn")
public class EndturnController {

    @Autowired
    private EndturnService endturnService;

    //triggers a turn advance in the current world
    @RequestMapping(method = RequestMethod.POST, value = "/{worldId}")
    public String endTurn(@PathVariable Integer worldId){
        this.endturnService.endturn(worldId);
        return "turn ended";
    }
}
