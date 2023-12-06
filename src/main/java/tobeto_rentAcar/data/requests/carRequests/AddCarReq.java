package tobeto_rentAcar.data.requests.carRequests;

import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AddCarReq(

        @NotNull
        int brandId,
        @NotNull
        int colorId,
        @NotNull
        int modelId,
        @NotNull
        int bodTypeId,
        @NotBlank()
        @Min(value = 1885)
        @Max(value = 2023)
        int year,
        @NotBlank()
        double rentalPrice,
        @NotBlank()
        String licensePlate,
        @NotBlank()
        DrivingLicenseType[] drivingLicenseTypes

) {

}
