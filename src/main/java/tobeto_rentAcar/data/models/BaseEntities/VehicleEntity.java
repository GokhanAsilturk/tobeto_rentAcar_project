package tobeto_rentAcar.data.models.BaseEntities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;
import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.ColorEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "vehicles")
@Inheritance(strategy = InheritanceType.JOINED)
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "vehicle_type_id")
    private ItemType itemType;

    @JoinColumn(name = "available_driving_license_types")
    List<DrivingLicenseType> availableDrivingLicenseTypes;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private BrandEntity brandEntity;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ColorEntity colorEntity;

    @Column(name = "year")
    private int year;

    @Column(name = "details")
    private String details;

    @Column(name = "rental_price")
    private double rentalPrice;


    @Column(name = "is_available")
    private boolean isAvailable;

    @Builder.Default
    @Column(name = "is_deleted")
    private boolean isDeleted = false;

    @LastModifiedDate
    @Column(name = "last_modified")
    private Date lastModified;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

}
