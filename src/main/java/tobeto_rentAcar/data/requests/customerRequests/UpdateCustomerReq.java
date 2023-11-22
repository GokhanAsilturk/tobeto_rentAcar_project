package tobeto_rentAcar.data.requests.customerRequests;

import lombok.Getter;
import lombok.Setter;
import tobeto_rentAcar.data.DTO.CustomerDTO;

@Getter
@Setter
public class UpdateCustomerReq {
    int id;
    String newName;
    String newSurname;
    String newEmailAddress;
    String newPassword;
}
