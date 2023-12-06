package tobeto_rentAcar.data.requests.commonRequests.vehicleRequests.vehicleFeaturesRequests;

import tobeto_rentAcar.data.models.vehicleFeatures.ColorEntity;

import javax.validation.constraints.NotBlank;

public record AddColorReq(

        @NotBlank()
        String name

) {



}
