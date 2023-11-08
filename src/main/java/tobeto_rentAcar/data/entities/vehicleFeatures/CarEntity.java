package tobeto_rentAcar.data.entities.vehicleFeatures;

import lombok.*;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.entities.BaseEntities.ItemEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
@SuperBuilder
public class CarEntity extends ItemEntity {

    @ManyToOne
    @JoinColumn(name = "brand_entity")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "body_type_entity")
    private BodyTypeEntity bodyTypeEntity;

    @ManyToOne
    @JoinColumn(name = "model_entity")
    private ModelEntity modelEntity;



    @Column(name = "details")
    private String details;

    @Column(name="daily_price")
    private double dailyPrice;


}
