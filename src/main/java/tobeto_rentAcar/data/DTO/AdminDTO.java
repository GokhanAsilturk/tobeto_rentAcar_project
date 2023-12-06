package tobeto_rentAcar.data.DTO;

import lombok.Builder;

@Builder
public record AdminDTO(int id,
                       String name,
                       String emailAddress,
                       double salary) {
}
