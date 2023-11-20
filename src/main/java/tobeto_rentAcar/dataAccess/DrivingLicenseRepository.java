package tobeto_rentAcar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicenseEntity, Integer> {

    Optional<List<DrivingLicenseEntity>> findAllByIsDeletedFalse();



}
