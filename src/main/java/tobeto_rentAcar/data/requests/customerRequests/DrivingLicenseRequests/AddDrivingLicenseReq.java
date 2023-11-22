package tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

public record AddDrivingLicenseReq(int customerId, String licenseNumber, DrivingLicenseType drivingLicenseType) {


    public DrivingLicenseEntity convertToEntity(CustomerEntity customerEntity) {
    //TODO ehliyete customer eklerken sıkıntı yaşıyorum.
        return DrivingLicenseEntity.builder()
                .customerEntity(customerEntity)
                .licenseNumber(this.licenseNumber)
                .licenseType(this.drivingLicenseType)
                .itemType(ItemType.DRIVING_LICENSE)
                .build();
    }
}
