package tobeto_rentAcar.data.DTO;

import lombok.Builder;
import tobeto_rentAcar.data.entities.BaseEntities.types.DrivingLicenseType;

@Builder
public record DrivingLicenseDTO(String licenseNumber,
                                DrivingLicenseType licenseType) {

}
