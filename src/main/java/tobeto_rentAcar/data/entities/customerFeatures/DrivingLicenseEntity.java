package tobeto_rentAcar.data.entities.customerFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.DrivingLicenseDTO;
import tobeto_rentAcar.data.entities.BaseEntities.ItemEntity;
import tobeto_rentAcar.data.entities.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.entities.CustomerEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "driver_licences")
@SuperBuilder
public class DrivingLicenseEntity extends ItemEntity {

    @ManyToOne
    @JoinColumn(name = "customer_entity_id")
    private CustomerEntity customerEntity;

    private String licenseNumber;

    private DrivingLicenseType licenseType;

    public DrivingLicenseDTO convertToDTO() {
        return DrivingLicenseDTO.builder()
                .licenseNumber(licenseNumber.toUpperCase())
                .licenseType(licenseType)
                .build();
    }
}
