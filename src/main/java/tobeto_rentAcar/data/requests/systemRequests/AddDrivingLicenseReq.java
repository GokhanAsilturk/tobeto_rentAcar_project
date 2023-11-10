package tobeto_rentAcar.data.requests.systemRequests;

import tobeto_rentAcar.data.entities.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.entities.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.data.entities.employerFeatures.DrivingLicenseEntity;

public record AddDrivingLicenseReq(CustomerEntity employerEntity, String drivingLicenseNumber,
                                   DrivingLicenseType licenseType) {


    DrivingLicenseEntity convertToEntity() {
        return DrivingLicenseEntity.builder()
                .employerEntity(employerEntity)
                .licenseNumber(drivingLicenseNumber)
                .licenseType(licenseType)
                .itemType(ItemType.DRIVING_LICENSE)
                .build();
    }

}
