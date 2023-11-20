package tobeto_rentAcar.data.DTO;

import lombok.Builder;
import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;

@Builder
public record DrivingLicenseDTO(String licenseNumber,
                                DrivingLicenseType licenseType) {

}
