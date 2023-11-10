package tobeto_rentAcar.data.entities.BaseEntities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.types.DrivingLicenseType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
public class DrivingLicenseTypeEntity extends ItemEntity {

    @Column(name = "driving_license_type")
    private DrivingLicenseType drivingLicenseType;
}
