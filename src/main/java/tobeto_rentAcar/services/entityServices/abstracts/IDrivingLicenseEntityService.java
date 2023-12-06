package tobeto_rentAcar.services.entityServices.abstracts;


import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

import java.util.List;

public interface IDrivingLicenseEntityService {

    DrivingLicenseEntity save(DrivingLicenseEntity drivingLicenseEntity);

    DrivingLicenseEntity getById(int id);

    List<DrivingLicenseEntity> getAll();

    List<DrivingLicenseEntity> getAllByIsDeletedFalse();

    List<DrivingLicenseEntity> getAllByIsDeletedTrue();

    DrivingLicenseEntity update(DrivingLicenseEntity drivingLicenseEntity);

    void softDelete(DrivingLicenseEntity drivingLicenseEntity);

    void delete(DrivingLicenseEntity drivingLicenseEntity);

}
