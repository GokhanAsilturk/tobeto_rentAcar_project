package tobeto_rentAcar.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.EmployerDTO;
import tobeto_rentAcar.data.entities.BaseEntities.UserEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employers")
@SuperBuilder
public class EmployerEntity extends UserEntity {

    public EmployerDTO convertToDto(){
        return EmployerDTO.builder()
                .id(getId())
                .name(getName())
                .surname(getSurname())
                .build();
    }

}
