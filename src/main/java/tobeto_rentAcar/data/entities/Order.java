package tobeto_rentAcar.data.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.ItemEntity;
import tobeto_rentAcar.data.entities.BaseEntities.UserEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@SuperBuilder
public class Order extends ItemEntity {

    @ManyToOne
    @JoinColumn(name = "user_entity")
    private UserEntity userEntity;


}
