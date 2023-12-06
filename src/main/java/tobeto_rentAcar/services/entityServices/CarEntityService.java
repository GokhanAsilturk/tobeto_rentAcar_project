package tobeto_rentAcar.services.entityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.models.vehicleEntites.CarEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;
import tobeto_rentAcar.dataAccess.CarRepository;
import tobeto_rentAcar.exception.DataNotFoundException;
import tobeto_rentAcar.exception.ExceptionType;
import tobeto_rentAcar.services.entityServices.abstracts.ICarEntityService;

import java.util.List;

@Service
public class CarEntityService implements ICarEntityService {

    private final CarRepository carRepository;

    @Autowired
    public CarEntityService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public CarEntity save(CarEntity carEntity) {
        return this.carRepository.save(carEntity);
    }

    @Override
    public CarEntity getById(int id) throws Exception {
        return this.carRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.VEHICLE_DATA_NOT_FOUND, "Car not found!"));
    }

    @Override
    public CarEntity getByLicensePlate(String licensePlate) throws Exception {
        return this.carRepository.findByLicensePlate(licensePlate)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.VEHICLE_DATA_NOT_FOUND, "Car not found :)"));
    }

    @Override
    public List<CarEntity> getAll() {
        return this.carRepository.findAll();
    }

    @Override
    public List<CarEntity> getAllByIsDeletedFalse() throws Exception {
        return this.carRepository.findAllByIsDeletedFalse()
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.VEHICLE_DATA_NOT_FOUND, "Car list is empty :)"));
    }

    @Override
    public List<CarEntity> getAllByIsDeletedTrue() throws Exception {
        return this.carRepository.findAllByIsDeletedTrue()
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.VEHICLE_DATA_NOT_FOUND, "Car list is empty :)"));
    }

    @Override
    public List<CarEntity> getAllByBrand(BrandEntity brandEntity) throws Exception {
        return this.carRepository.findAllByBrandEntity(brandEntity)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.USER_LIST_NOT_FOUND, "Car list is empty :)"));
    }

    @Override
    public List<CarEntity> getAllByYearBetween(int minYear, int maxYear) throws Exception {
        return this.carRepository.findAllByYearBetween(minYear, maxYear)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.USER_LIST_NOT_FOUND, "Car list is empty :)"));
    }

    @Override
    public List<CarEntity> getAllByRentalPriceBetween(int minPrice, int maxPrice) throws Exception {
        return this.carRepository.findAllByRentalPriceBetween(minPrice, maxPrice)
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.USER_LIST_NOT_FOUND, "Car list is empty :)"));
    }

    @Override
    public CarEntity getByTopRentalPrice() throws Exception {
        return this.carRepository.findTopByRentalPriceDesc()
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "Car not found! :)"));
    }

    @Override
    public List<CarEntity> getAllSortedByRentalPrice() throws Exception {
        return this.carRepository.findByRentalPriceOrderByRentalPriceDesc()
                .orElseThrow(() -> new DataNotFoundException(ExceptionType.USER_LIST_NOT_FOUND, "Car list is empty! :)"));
    }

    @Override
    public CarEntity update(CarEntity carEntity) throws Exception {
        return this.save(carEntity);
    }

    @Override
    public void softDelete(CarEntity carEntity) throws Exception {
        try {
            carEntity.setDeleted(true);
            this.carRepository.save(carEntity);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    //ADMIN
    @Override
    public void delete(CarEntity carEntity) throws Exception {
        try {
            this.carRepository.delete(carEntity);
        } catch (Exception e) {
            throw new Exception();
        }
    }
}
