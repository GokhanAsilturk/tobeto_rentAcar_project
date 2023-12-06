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
import tobeto_rentAcar.services.systemServices.EntityUpdaterUtil;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@SuperBuilder
public class CustomerEntity extends UserEntity {


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
// customer da yapılan tüm değişiklikler ehliyet sınıfında da değişir.
    @JoinColumn(name = "driving_license_id", referencedColumnName = "id")
    private DrivingLicenseEntity drivingLicenseEntity;

    public CustomerDTO convertToDto() {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id(getId())
                .name(StringUtils.capitalize(getName()))
                .surname(getSurname().toUpperCase())
                .emailAddress(getEmailAddress())
                .build();
        if (this.drivingLicenseEntity != null) {
            EntityUpdaterUtil.updateEntityFields(customerDTO.drivingLicenseDTO(), this.drivingLicenseEntity.convertToDTO());
        }
        return customerDTO;
    }

}
