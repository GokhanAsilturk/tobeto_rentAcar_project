package tobeto_rentAcar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import tobeto_rentAcar.data.models.vehicleEntites.CarEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {

    Optional<CarEntity> findByLicensePlate(String licensePlate);

    Optional<List<CarEntity>> findAllByIsDeletedFalse();

    Optional<List<CarEntity>> findAllByIsDeletedTrue();

    Optional<List<CarEntity>> findAllByBrandEntity(BrandEntity brandEntity);

    Optional<List<CarEntity>> findAllByYearBetween(int minYear, int maxYear);

    Optional<List<CarEntity>> findAllByRentalPriceBetween(int minPrice, int maxPrice);

    Optional<CarEntity> findTopByRentalPriceDesc(); //İsimlendirmede Top var. yani en yüksek fiyatlıyı getirir.

    Optional<List<CarEntity>> findByRentalPriceOrderByRentalPriceDesc(); //top yok. Desc = A->Z sırala.

}
