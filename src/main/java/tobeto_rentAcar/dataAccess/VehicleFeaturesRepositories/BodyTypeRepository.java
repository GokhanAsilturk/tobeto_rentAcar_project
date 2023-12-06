package tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;

public interface BodyTypeRepository extends JpaRepository<BodyTypeEntity, Integer> {

}
