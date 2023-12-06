package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.models.vehicleEntites.CarEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;

import java.util.List;

public interface ICarEntityService {

    CarEntity save(CarEntity carEntity);

    CarEntity getById(int id) throws Exception;

    CarEntity getByLicensePlate(String licensePlate) throws Exception;

    List<CarEntity> getAll();

    List<CarEntity> getAllByIsDeletedFalse() throws Exception;

    List<CarEntity> getAllByIsDeletedTrue() throws Exception;

    List<CarEntity> getAllByBrand(BrandEntity brandEntity) throws Exception;

    List<CarEntity> getAllByYearBetween(int minYear, int maxYear) throws Exception;

    List<CarEntity> getAllByRentalPriceBetween(int minPrice, int maxPrice) throws Exception;

    CarEntity getByTopRentalPrice() throws Exception;

    List<CarEntity> getAllSortedByRentalPrice() throws Exception;

    CarEntity update(CarEntity carEntity) throws Exception;

    void softDelete(CarEntity carEntity) throws Exception;

    void delete(CarEntity carEntity) throws Exception;

}
