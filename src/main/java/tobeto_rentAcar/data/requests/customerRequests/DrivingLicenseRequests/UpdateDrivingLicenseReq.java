package tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;

public record UpdateDrivingLicenseReq(int customerId, String licenseNumber, DrivingLicenseType drivingLicenseType) {
}
