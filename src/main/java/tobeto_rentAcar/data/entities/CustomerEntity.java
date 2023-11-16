package tobeto_rentAcar.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.StringUtils;
import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.entities.BaseEntities.UserEntity;
import tobeto_rentAcar.data.entities.customerFeatures.DrivingLicenseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@SuperBuilder
public class CustomerEntity extends UserEntity {


    @ManyToOne
    @JoinColumn(name = "driving_license_entity_id")
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
