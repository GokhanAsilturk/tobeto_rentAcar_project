package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.entities.EmployerEntity;

public interface EmployerRepository extends JpaRepository<EmployerEntity, Integer> {
}
