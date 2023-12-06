package tobeto_rentAcar.data.requests.systemRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.RentalDetailEntity;
import tobeto_rentAcar.data.models.vehicleEntites.CarEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public record CreateRentalDetailReq(
        @NotBlank()
        CustomerEntity customerEntity,
        @NotBlank()
        CarEntity carEntity,
        @NotBlank()
        String startDate,
        @NotBlank()
        String endDate,

        double totalDailyPrice,
        double totalPrice) {

    RentalDetailEntity convertToEntity() {
        return RentalDetailEntity.builder()
                .customerEntity(customerEntity)
                .carEntity(carEntity)
                .startDate(LocalDate.parse(startDate))
                .endDate(LocalDate.parse(endDate))
                .itemType(ItemType.RENTAL_DETAIL)
                .build();
    }
}
