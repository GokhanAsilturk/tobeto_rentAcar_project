package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tobeto_rentAcar.data.models.CustomerEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    Optional<CustomerEntity> findByEmailAddress(String emailAddress);

    Optional<List<CustomerEntity>> findAllByIsDeletedFalse();

    Optional<CustomerEntity> findByIdAndIsDeletedFalse(int id);
}
