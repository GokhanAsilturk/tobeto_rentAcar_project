package tobeto_rentAcar.data.requests.systemRequests;

import tobeto_rentAcar.data.entities.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.entities.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.data.entities.customerFeatures.DrivingLicenseEntity;

public record AddDrivingLicenseReq(CustomerEntity customerEntity, String drivingLicenseNumber,
                                   DrivingLicenseType licenseType) {


    DrivingLicenseEntity convertToEntity() {
        return DrivingLicenseEntity.builder()
                .customerEntity(customerEntity)
                .licenseNumber(drivingLicenseNumber)
                .licenseType(licenseType)
                .itemType(ItemType.DRIVING_LICENSE)
                .build();
    }

}
