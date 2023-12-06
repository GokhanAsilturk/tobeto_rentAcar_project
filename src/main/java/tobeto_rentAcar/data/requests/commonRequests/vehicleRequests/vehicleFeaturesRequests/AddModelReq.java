package tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests;

import tobeto_rentAcar.data.models.vehicleFeatures.ModelEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AddModelReq(

        @NotBlank
        String name,
        @NotNull
        int brandId
) {


}
