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
@Entity
@Table(name = "rental_details")
@SuperBuilder
@NoArgsConstructor
public class RentalDetailEntity extends ItemEntity {

    @ManyToOne
    @JoinColumn(name = "customer_entity_id")
    private CustomerEntity customerEntity;

    @ManyToOne
    @JoinColumn(name = "car_entity_id")
    private CarEntity carEntity;

    @Column(name = "start_date", nullable = true)
    @DateTimeFormat
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    @DateTimeFormat
    private LocalDate endDate;

    @Column(name = "total_days", nullable = true)
    @DateTimeFormat
    private long totalDays; // toplam gün sayısını hesap ediyoruz.

    //TODO totaldailyPrice ve total price toEntity methoduna eklenmedi.
    // service sınıfında bu işlemler set edilecek. kampanyalar ve indirimler için
    @Column(name = "total_daily_price", nullable = true)
    private double totalDailyPrice;

    @Column(name = "total_price")
    private double totalPrice;

    public void calculateTotalDaysAndTotalDailyPrice() {
        this.totalDays = startDate.until(endDate, ChronoUnit.DAYS);
        this.totalDailyPrice = totalDays * carEntity.getRentalPrice();
    }

//    long calculateTotalDays(){
//        assert startDate != null;
//        assert endDate != null;
//        return this.totalDays = startDate.until(endDate, ChronoUnit.DAYS);
//    }

}
