package ro.schedulerbot.security.repo;



import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ro.schedulerbot.security.model.SecurityUser;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

  Optional<SecurityUser> findByUsername(String username);

}
