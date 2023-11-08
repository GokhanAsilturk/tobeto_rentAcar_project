package tobeto_rentAcar.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.UserEntity;
import tobeto_rentAcar.data.entities.BaseEntities.types.UserType;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admins")
@SuperBuilder
public class AdminEntity extends UserEntity {

    private UserType userType = UserType.ADMIN;

    @Column(name = "salary")
    private double salary;


}
