package tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;

public interface ModelRepository extends JpaRepository<ModelEntity, Integer> {
}
