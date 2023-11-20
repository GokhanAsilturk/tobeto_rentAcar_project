package tobeto_rentAcar.data.models.customerFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.DrivingLicenseDTO;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;
import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.models.CustomerEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driving_licences")
@SuperBuilder
public class DrivingLicenseEntity extends ItemEntity {

    @OneToOne
    @JoinColumn(name = "customer_entity_id", referencedColumnName = "id")
    private CustomerEntity customerEntity;

    @Column(name = "license number", unique = true)
    private String licenseNumber;

    @Column(name = "license_type")
    private DrivingLicenseType licenseType;

    public DrivingLicenseDTO convertToDTO() {
        return DrivingLicenseDTO.builder()
                .licenseNumber(licenseNumber.toUpperCase())
                .licenseType(licenseType)
                .build();
    }
}
