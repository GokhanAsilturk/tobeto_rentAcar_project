package tobeto_rentAcar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.entities.BaseEntities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
