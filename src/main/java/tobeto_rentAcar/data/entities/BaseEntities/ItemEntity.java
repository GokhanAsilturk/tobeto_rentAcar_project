package tobeto_rentAcar.data.entities.BaseEntities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.types.ItemType;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@SuperBuilder
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemEntity extends BaseEntity {

    @Column(name = "item_type")
    protected ItemType itemType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
}
