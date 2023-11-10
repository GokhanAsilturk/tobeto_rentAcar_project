package tobeto_rentAcar.data.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import tobeto_rentAcar.data.entities.BaseEntities.ItemEntity;
import tobeto_rentAcar.data.entities.vehicleFeatures.CarEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental_details")
@SuperBuilder
public class RentalDetailEntity extends ItemEntity {


    @ManyToOne
    @JoinColumn(name = "customer_entity_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "car_entity_id")
    private CarEntity carEntity;

    @Column(name = "start_date")
    @DateTimeFormat
    private LocalDate startDate;

    @Column(name = "end_date")
    @DateTimeFormat
    private LocalDate endDate;

    @Column(name = "total_days")
    @DateTimeFormat
    private long totalDays = startDate.until(endDate, ChronoUnit.DAYS); // toplam gün sayısını hesap ediyoruz.

    //TODO totaldailyPrice ve total price toEntity methoduna eklenmedi.
    // service sınıfında bu işlemler set edilecek. kampanyalar ve indirimler için
    @Column(name = "total_daily_price")
    private double totalDailyPrice;

    @Column(name = "total_price")
    private double totalPrice;


}
