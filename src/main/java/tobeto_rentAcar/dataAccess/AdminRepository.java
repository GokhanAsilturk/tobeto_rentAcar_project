package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.entities.AdminEntity;


public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
}
