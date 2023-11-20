package tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

public record AddDrivingLicenseReq(int customerId, String licenseNumber, DrivingLicenseType drivingLicenseType) {


    public DrivingLicenseEntity convertToEntity() {

        //TODO customer eklemek için service de işlem yapılacak
        return DrivingLicenseEntity.builder()
                .licenseNumber(this.licenseNumber)
                .licenseType(this.drivingLicenseType)
                .itemType(ItemType.DRIVING_LICENSE)
                .build();
    }
}
