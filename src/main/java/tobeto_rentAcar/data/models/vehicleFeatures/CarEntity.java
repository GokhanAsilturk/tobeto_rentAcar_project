package tobeto_rentAcar.data.models.vehicleFeatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.models.BaseEntities.ItemEntity;

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
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyTypeEntity bodyTypeEntity;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    @Column(name = "year")
    private int year;

    @Column(name = "license_plate", unique = true)
    private String licensePlate;

    @Column(name = "details")
    private String details;

    @Column(name = "rental_price")
    private double rentalPrice;

    @Column(name = "is_available")
    private boolean isAvailable;

}
