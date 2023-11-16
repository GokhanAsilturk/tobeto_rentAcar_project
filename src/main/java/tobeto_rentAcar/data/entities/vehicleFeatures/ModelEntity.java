package tobeto_rentAcar.data.entities.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.ItemEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "models")
@SuperBuilder
public class ModelEntity extends ItemEntity {

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "brand")
    private BrandEntity brandEntity;
}
