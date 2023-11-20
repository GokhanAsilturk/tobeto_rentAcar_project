package tobeto_rentAcar.data.models.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colors")
@SuperBuilder
public class ColorEntity extends ItemEntity {

    @Column(name = "name")
    private String name;

}
