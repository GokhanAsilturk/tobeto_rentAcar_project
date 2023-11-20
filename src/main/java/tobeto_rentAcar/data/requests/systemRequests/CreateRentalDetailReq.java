package tobeto_rentAcar.data.requests.systemRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.RentalDetailEntity;
import tobeto_rentAcar.data.models.vehicleFeatures.CarEntity;

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
