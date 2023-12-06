package tobeto_rentAcar.dataAccess.VehicleFeaturesRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, Integer> {
}
