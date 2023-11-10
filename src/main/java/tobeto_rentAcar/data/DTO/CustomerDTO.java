package tobeto_rentAcar.data.DTO;

import lombok.Builder;


@Builder
public record CustomerDTO(int id,
                          String name,
                          String surname,
                          DrivingLicenseDTO drivingLicenseDTO,
                          String emailAddress) {
}
