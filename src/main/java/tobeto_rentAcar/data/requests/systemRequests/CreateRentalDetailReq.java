package tobeto_rentAcar.data.requests.systemRequests;

import tobeto_rentAcar.data.entities.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.data.entities.RentalDetailEntity;
import tobeto_rentAcar.data.entities.vehicleFeatures.CarEntity;

import java.time.LocalDate;

public record CreateRentalDetailReq(
        CustomerEntity customerEntity
        , CarEntity carEntity
        , String startDate
        , String endDate
        , double totalDailyPrice
        , double totalPrice) {

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
