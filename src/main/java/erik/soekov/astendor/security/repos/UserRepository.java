package erik.soekov.astendor.security.repos;

import erik.soekov.astendor.security.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
