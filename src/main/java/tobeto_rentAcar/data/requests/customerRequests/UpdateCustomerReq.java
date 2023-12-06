package tobeto_rentAcar.data.requests.customerRequests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCustomerReq {
    int id;
    String newName;
    String newSurname;
    String newEmailAddress;
    String newPassword;
}
