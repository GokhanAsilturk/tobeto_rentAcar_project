package tobeto_rentAcar.data.models.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BrandDto;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brands")
@SuperBuilder
public class BrandEntity extends ItemEntity {

    @Column(name = "name", unique = true)
    private String name;

    public BrandDto convertToDto(){
        return BrandDto.builder()
                .id(getId())
                .name(getName())
                .build();
    }
}
