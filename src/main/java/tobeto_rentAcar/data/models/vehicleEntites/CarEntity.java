package tobeto_rentAcar.data.models.vehicleEntites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import tobeto_rentAcar.data.DTO.CarDTO;
import tobeto_rentAcar.data.models.BaseEntities.VehicleEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
@SuperBuilder
public class CarEntity extends VehicleEntity {

    @ManyToOne
    @JoinColumn(name = "model_id")
    private ModelEntity modelEntity;

    @ManyToOne
    @JoinColumn(name = "body_type_id")
    private BodyTypeEntity bodyTypeEntity;

    @Column(name = "license_plate", unique = true)
    private String licensePlate;


    public CarDTO convertToDTO() {
        return CarDTO.builder()
                .id(getId())
                .brand(getBrandEntity().getName())
                .model(getModelEntity().getName())
                .bodyType(getBodyTypeEntity().getName())
                .year(getYear())
                .availableLicenseType(getAvailableDrivingLicenseTypes())
                .rentalPrice(getRentalPrice())
                .color(getColorEntity().getName())
                .details(getDetails())
                .isAvailable(isAvailable())
                .build();
    }
}
