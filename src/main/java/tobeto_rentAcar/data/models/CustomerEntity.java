package tobeto_rentAcar.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.models.BaseEntities.UserEntity;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@SuperBuilder
public class CustomerEntity extends UserEntity {


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driving_license_id", referencedColumnName = "id")
    private DrivingLicenseEntity drivingLicenseEntity;

    public CustomerDTO convertToDto() {
        return CustomerDTO.builder()
                .id(getId())
                .name(StringUtils.capitalize(getName()))
                .surname(getSurname().toUpperCase())
                .emailAddress(getEmailAddress())
                .drivingLicenseDTO(drivingLicenseEntity.convertToDTO())
                .build();
    }

}
