package tobeto_rentAcar.data.DTO;

import lombok.Builder;

@Builder
public record EmployerDTO(int id, String name, String surname ,String emailAddress) {
}
