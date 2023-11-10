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
@Table(name = "cars")
@SuperBuilder
public class CarEntity extends ItemEntity {

    @ManyToOne
    @JoinColumn(name = "brand_entity_id")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "model_entity_id")
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn(name = "body_type_entity_id")
    private BodyTypeEntity bodyTypeEntity;

    @Column(name = "year")
    private int year;

    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "details")
    private String details;

    @Column(name = "rental_price")
    private double rentalPrice;

    @Column(name = "is_available")
    private boolean isAvailable;

}
