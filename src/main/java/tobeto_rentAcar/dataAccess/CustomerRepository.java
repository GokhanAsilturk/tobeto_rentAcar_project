package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    CustomerEntity findByEmailAddress(String emailAddress);

}
