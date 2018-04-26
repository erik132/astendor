package erik.soekov.astendor.security.services;

import erik.soekov.astendor.security.dtos.UserDTO;
import erik.soekov.astendor.security.exceptions.PasswordMismatchException;
import erik.soekov.astendor.security.exceptions.UsernameExistsException;

public interface AstendorUserService {

    public void registerUser(UserDTO userDTO) throws UsernameExistsException, PasswordMismatchException;
}
