package uz.ems.testcicd.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ems.testcicd.model.TasbehCount;

public interface TasbehRepository extends JpaRepository<TasbehCount, Long> {
    TasbehCount findByUserId(Long userId);
}
