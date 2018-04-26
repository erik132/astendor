package erik.soekov.astendor.security.services;

import erik.soekov.astendor.security.models.AstendorUserDetails;
import erik.soekov.astendor.security.models.User;
import erik.soekov.astendor.security.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AstendorUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("username not found");
        }

        return new AstendorUserDetails(user);
    }
}
