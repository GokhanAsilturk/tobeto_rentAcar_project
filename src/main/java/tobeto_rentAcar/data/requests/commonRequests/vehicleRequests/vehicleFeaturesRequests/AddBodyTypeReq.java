package tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.ItemType;
import tobeto_rentAcar.data.models.vehicleFeatures.BodyTypeEntity;

import javax.validation.constraints.NotBlank;

public record AddBodyTypeReq(
        @NotBlank()
        String name

) {

}
