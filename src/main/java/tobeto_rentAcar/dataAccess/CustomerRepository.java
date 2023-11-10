package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.entities.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByEmailAddress(String emailAddress);

    Optional<List<CustomerEntity>> findAllByIsDeletedFalse();

    Optional<CustomerEntity> findByIdAndIsDeletedFalse(int id);
}
