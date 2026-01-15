package uz.ems.testcicd.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ems.testcicd.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String u, String p);
}
