package tobeto_rentAcar.data.DTO;

import lombok.Builder;
import tobeto_rentAcar.data.models.BaseEntities.types.DrivingLicenseType;

import java.util.List;

@Builder
public record CarDTO(
        int id,
        String brand,
        String model,
        String bodyType,
        String color,
        int year,
        double rentalPrice,
        boolean isAvailable,
        String licensePlate,
        List<DrivingLicenseType> availableLicenseType,
        String details
) {
}
