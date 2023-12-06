package tobeto_rentAcar.data.DTO.VehicleFeaturesDTO;

import lombok.Builder;

@Builder
public record ModelDto(int id, String name, String brand) {
}
