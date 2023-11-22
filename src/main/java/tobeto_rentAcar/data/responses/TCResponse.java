package tobeto_rentAcar.data.responses;

import lombok.Builder;

@Builder
public record TCResponse<T>(String message, T response, boolean isSuccess) {

}
