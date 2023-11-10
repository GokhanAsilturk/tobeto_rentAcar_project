package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByEmailReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;

import java.util.List;

public interface ICustomerService {
    CustomerDTO add(AddCustomerReq addCustomerReq);

    CustomerDTO getById(GetCustomerByIdReq getCustomerByIdReq);

    CustomerDTO getByEmailAddress(GetCustomerByEmailReq getCustomerByEmailReq);

    List<CustomerDTO> getAll();

    CustomerDTO update(UpdateCustomerReq updateCustomerReq) throws Exception;

    void delete(DeleteUserReq deleteUserReq) throws Exception;
}
