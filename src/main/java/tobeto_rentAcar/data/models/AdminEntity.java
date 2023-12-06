package tobeto_rentAcar.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.AdminDTO;
import tobeto_rentAcar.data.models.BaseEntities.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
@SuperBuilder
public class AdminEntity extends UserEntity {


    @Column(name = "salary")
    private double salary;

    public AdminDTO convertToDTO() {
        return AdminDTO.builder()
                .id(getId())
                .name(getName())
                .emailAddress(getEmailAddress())
                .salary(getSalary())
                .build();
    }

}
