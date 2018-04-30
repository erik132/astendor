package erik.soekov.astendor.security.services;

import erik.soekov.astendor.security.dtos.UserDTO;
import erik.soekov.astendor.security.exceptions.PasswordMismatchException;
import erik.soekov.astendor.security.exceptions.UsernameExistsException;
import erik.soekov.astendor.security.models.User;

public interface AstendorUserService {

    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException;
    public User findByUsername(String username);
}
