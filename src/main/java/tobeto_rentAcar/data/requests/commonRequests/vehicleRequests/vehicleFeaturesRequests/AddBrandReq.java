package tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests;

import tobeto_rentAcar.data.models.vehicleFeatures.BrandEntity;

import javax.validation.constraints.NotBlank;

public record AddBrandReq(
        @NotBlank()
        String name
) {


}
