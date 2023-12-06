package tobeto_rentAcar.data.models.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.VehicleFeaturesDTO.BodyTypeDto;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "body_types")
@SuperBuilder
public class BodyTypeEntity extends ItemEntity {

    @Column(name = "body_type", unique = true)
    private String name;

    public BodyTypeDto convertToDto(){
        return BodyTypeDto.builder()
                .id(getId())
                .name(getName())
                .build();
    }
}
