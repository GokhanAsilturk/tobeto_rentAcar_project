package tobeto_rentAcar.data.models.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.ModelDto;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;

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
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    public ModelDto convertToDto() {
        return ModelDto.builder()
                .id(getId())
                .name(getName())
                .brand(getBrandEntity().getName())
                .build();
    }

}
