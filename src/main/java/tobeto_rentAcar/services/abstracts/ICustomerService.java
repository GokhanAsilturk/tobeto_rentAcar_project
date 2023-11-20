package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.DTO.DrivingLicenseDTO;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.*;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.AddDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.GetDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.UpdateDrivingLicenseReq;

import java.util.List;

public interface ICustomerService {
    CustomerDTO add(AddCustomerReq addCustomerReq);

    CustomerDTO getById(GetCustomerByIdReq getCustomerByIdReq);

    CustomerDTO getByEmailAddress(GetCustomerByEmailReq getCustomerByEmailReq);

    List<CustomerDTO> getAll();

    CustomerDTO update(UpdateCustomerReq updateCustomerReq) throws Exception;

    void delete(DeleteUserReq deleteUserReq) throws Exception;

    //---------------------------------------------------------------------------------------------------//

    CustomerDTO addDrivingLicense(AddDrivingLicenseReq addDrivingLicenseReq) throws Exception;

    DrivingLicenseDTO updateDrivingLicense(UpdateDrivingLicenseReq updateDrivingLicenseReq) throws Exception;

    DrivingLicenseDTO getDrivingLicense(GetDrivingLicenseReq getDrivingLicenseReq);
}
