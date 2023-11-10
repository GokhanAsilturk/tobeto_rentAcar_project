package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;

import java.util.List;

public interface ICustomerService {
    CustomerDTO add(AddCustomerReq addCustomerReq);

    CustomerDTO getById(GetCustomerByIdReq getCustomerByIdReq);

    List<CustomerDTO> getAll();

    CustomerDTO update(UpdateCustomerReq updateCustomerReq) throws IllegalAccessException;

    void delete(DeleteUserReq deleteUserReq);
}
