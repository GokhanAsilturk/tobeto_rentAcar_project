package tobeto_rentAcar.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
    @Transactional
    @Modifying
    @Query("""
            update CustomerEntity c set c.name = ?1, c.surname = ?2, c.emailAddress = ?3, c.password = ?4, c.drivingLicenseEntity = ?5
            where c.name = ?6 and c.surname = ?7 and c.emailAddress = ?8 and c.password = ?9 and c.drivingLicenseEntity = ?10""")
    int updateCustomerRepo(String name, String surname, String emailAddress, String password, DrivingLicenseEntity drivingLicenseEntity, String name1, String surname1, String emailAddress1, String password1, DrivingLicenseEntity drivingLicenseEntity1);



    Optional<CustomerEntity> findByEmailAddress(String emailAddress);

    Optional<List<CustomerEntity>> findAllByIsDeletedFalse();

    Optional<CustomerEntity> findByIdAndIsDeletedFalse(int id);
}
