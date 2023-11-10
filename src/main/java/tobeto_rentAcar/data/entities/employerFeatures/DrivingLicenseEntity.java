package tobeto_rentAcar.data.entities.employerFeatures;

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
    @JoinColumn(name = "employer_entity_id")
    private CustomerEntity employerEntity;

    private String licenseNumber;

    private DrivingLicenseType licenseType;

    public DrivingLicenseDTO convertToDTO(){
       return DrivingLicenseDTO.builder()
                .licenseNumber(licenseNumber.toUpperCase())
                .licenseType(licenseType)
                .build();
    }
}
