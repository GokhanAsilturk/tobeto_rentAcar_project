package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.DTO.DrivingLicenseDTO;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.AddDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.GetDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.UpdateDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;

import java.util.List;

public interface ICustomerService {
    CustomerDTO add(AddCustomerReq addCustomerReq);

    CustomerDTO getById(int id);

    CustomerDTO getByEmailAddress(String emailAddress);

    List<CustomerDTO> getAll();

    CustomerDTO update(UpdateCustomerReq updateCustomerReq) throws Exception;

    void delete(DeleteUserReq deleteUserReq) throws Exception;

    //---------------------------------------------------------------------------------------------------//

    CustomerDTO addDrivingLicense(AddDrivingLicenseReq addDrivingLicenseReq) throws Exception;

    DrivingLicenseDTO updateDrivingLicense(UpdateDrivingLicenseReq updateDrivingLicenseReq) throws Exception;

    DrivingLicenseDTO getDrivingLicense(GetDrivingLicenseReq getDrivingLicenseReq);
}
