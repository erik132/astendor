package erik.soekov.astendor.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String landingPage(){
        return "landingPage";
    }

    @RequestMapping("/astendor/worldlist")
    public String showWorldList(){
        return "astendor/worldList";
    }

}
