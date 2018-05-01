package erik.soekov.astendor.security.services;

import erik.soekov.astendor.security.dtos.UserDTO;
import erik.soekov.astendor.security.exceptions.PasswordMismatchException;
import erik.soekov.astendor.security.exceptions.UsernameExistsException;
import erik.soekov.astendor.security.models.AstendorUserDetails;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AstendorUserDetailsService implements UserDetailsService, AstendorUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }

        return new AstendorUserDetails(user);
    }

    @Override
    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException {
        User user = null;
        if(!userDTO.isPasswordMatch()){
            throw new PasswordMismatchException();
        }

        user = this.userRepository.findByUsername(userDTO.getUsername());
        if(user == null){
            userDTO.setPassword(this.passwordEncoder.encode(userDTO.getPassword()));
            this.userRepository.save(new User(userDTO));
        }else{
            throw new UsernameExistsException();
        }
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public User findByAuthentication(Authentication authentication) {
        return this.userRepository.findByUsername(authentication.getName());
    }
}
