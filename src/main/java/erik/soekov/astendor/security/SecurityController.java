package erik.soekov.astendor.security;

import erik.soekov.astendor.security.dtos.UserDTO;
import erik.soekov.astendor.security.exceptions.PasswordMismatchException;
import erik.soekov.astendor.security.exceptions.UsernameExistsException;
import erik.soekov.astendor.security.services.AstendorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private AstendorUserService astendorUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new UserDTO());
        return "users/registration";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public String registerUser(@Valid UserDTO userDTO, Model model){

        try{
            this.astendorUserService.registerUser(userDTO);
        }catch (PasswordMismatchException pme){
            model.addAttribute("error", "Password mismatch");
        }catch (UsernameExistsException uee){
            model.addAttribute("error", "Username already exists");
        }
        model.addAttribute("user", userDTO);
        return "users/registration";
    }

    @RequestMapping("/login")
    public String showLoginform(){
        return "users/login";
    }


}
