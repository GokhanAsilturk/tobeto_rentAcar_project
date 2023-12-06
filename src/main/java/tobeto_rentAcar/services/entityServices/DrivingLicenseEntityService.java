package tobeto_rentAcar.services.entityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;
import tobeto_rentAcar.dataAccess.DrivingLicenseRepository;
import tobeto_rentAcar.exception.DataNotFoundException;
import tobeto_rentAcar.exception.ExceptionType;
import tobeto_rentAcar.services.entityServices.abstracts.IDrivingLicenseEntityService;

import java.util.List;

@Service
public class DrivingLicenseEntityService implements IDrivingLicenseEntityService {

    private final DrivingLicenseRepository drivingLicenseRepository;

    @Autowired
    public DrivingLicenseEntityService(DrivingLicenseRepository drivingLicenseRepository) {
        this.drivingLicenseRepository = drivingLicenseRepository;
    }


    @Override
    public DrivingLicenseEntity save(DrivingLicenseEntity drivingLicenseEntity) {
        return this.drivingLicenseRepository.save(drivingLicenseEntity);
    }


    @Override
    public DrivingLicenseEntity getById(int id) {
        return this.drivingLicenseRepository.findById(id).orElseThrow(() ->
                new DataNotFoundException(ExceptionType.DRIVING_LICENSE_NOT_FOUND, "Driving License Not Found! :)"));
    }

    @Override
    public List<DrivingLicenseEntity> getAll() {
        return this.drivingLicenseRepository.findAll();
    }

    @Override
    public List<DrivingLicenseEntity> getAllByIsDeletedFalse() {
        return this.drivingLicenseRepository.findAllByIsDeletedFalse().orElseThrow(() ->
                new DataNotFoundException(ExceptionType.DRIVING_LICENSE_LIST_NOT_FOUND, "Driving License is Empty! :)"));
    }

    @Override
    public List<DrivingLicenseEntity> getAllByIsDeletedTrue() {
        return this.drivingLicenseRepository.findAllByIsDeletedTrue().orElseThrow(() ->
                new DataNotFoundException(ExceptionType.DRIVING_LICENSE_LIST_NOT_FOUND, "Deleted Driving License List is Empty! :)"));
    }


    @Override
    public DrivingLicenseEntity update(DrivingLicenseEntity drivingLicenseEntity) {

        return this.save(drivingLicenseEntity);
    }

    @Override
    public void softDelete(DrivingLicenseEntity drivingLicenseEntity) {
        drivingLicenseEntity.setDeleted(true);
        this.save(drivingLicenseEntity);
    }

    @Override
    public void delete(DrivingLicenseEntity drivingLicenseEntity) {
        this.drivingLicenseRepository.delete(drivingLicenseEntity);
    }
}
