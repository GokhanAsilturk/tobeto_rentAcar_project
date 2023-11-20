package tobeto_rentAcar.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.DTO.DrivingLicenseDTO;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.customerFeatures.DrivingLicenseEntity;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.AddDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.GetDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.UpdateDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByEmailReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;
import tobeto_rentAcar.services.abstracts.ICustomerService;
import tobeto_rentAcar.services.entityServices.CustomerEntityService;
import tobeto_rentAcar.services.entityServices.DrivingLicenseEntityService;
import tobeto_rentAcar.services.systemServices.EntityUpdaterUtil;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerEntityService customerEntityService;

    private final DrivingLicenseEntityService drivingLicenseEntityService;

    @Autowired
    public CustomerService(CustomerEntityService customerEntityService, DrivingLicenseEntityService drivingLicenseEntityService) {
        this.customerEntityService = customerEntityService;
        this.drivingLicenseEntityService = drivingLicenseEntityService;
    }


    @Override
    public CustomerDTO add(AddCustomerReq addCustomerReq) {
        return this.customerEntityService.save(addCustomerReq.convertToEntity()).convertToDto();
    }

    @Override
    public CustomerDTO getById(GetCustomerByIdReq getCustomerByIdReq) {
        return this.customerEntityService.getById(getCustomerByIdReq.id()).convertToDto();
    }

    @Override
    public CustomerDTO getByEmailAddress(GetCustomerByEmailReq getCustomerByEmailReq) {
        return this.customerEntityService.getByEmailAddress(getCustomerByEmailReq.email()).convertToDto();
    }

    @Override
    public List<CustomerDTO> getAll() {
        return this.customerEntityService.getAll().stream()
                .map(CustomerEntity::convertToDto).toList();
    }

    @Override
    public CustomerDTO update(UpdateCustomerReq updateCustomerReq) throws Exception {
        CustomerEntity customerEntity = this.customerEntityService.getById(updateCustomerReq.customerDTO().id());

        EntityUpdaterUtil.updateEntityFields(customerEntity, updateCustomerReq);

        return this.customerEntityService.update(customerEntity).convertToDto();
    }

    @Override
    public void delete(DeleteUserReq deleteUserReq) throws Exception {
        //Customer sadece soft delete yapabilir.
        this.customerEntityService.softDelete(customerEntityService.getById(deleteUserReq.id()));

    }


    //----------------------------------------------------------------------------------------------------------------//

    //TODO driving license servis işlemleri tamamlandı. controller a bağlantılar eklendi.
    @Override
    public CustomerDTO addDrivingLicense(AddDrivingLicenseReq addDrivingLicenseReq) throws Exception {
        DrivingLicenseEntity drivingLicenseEntity = addDrivingLicenseReq.convertToEntity();
        CustomerEntity customerEntity = this.customerEntityService.getById(addDrivingLicenseReq.customerId());

        //Customer, ehliyetin convertToEntity methodunda eklenemediği için burada ekliyoruz.
        drivingLicenseEntity.setCustomerEntity(customerEntity);
        this.drivingLicenseEntityService.save(drivingLicenseEntity);

        //Customer a ehliyeti set ediyoruz.
        customerEntity.setDrivingLicenseEntity(drivingLicenseEntity);

        return this.customerEntityService.update(customerEntity).convertToDto();
    }

    @Override
    public DrivingLicenseDTO updateDrivingLicense(UpdateDrivingLicenseReq updateDrivingLicenseReq) throws Exception {
        CustomerEntity customerEntity = this.customerEntityService.getById(updateDrivingLicenseReq.customerId());
        DrivingLicenseEntity drivingLicenseEntity = customerEntity.getDrivingLicenseEntity();

        EntityUpdaterUtil.updateEntityFields(drivingLicenseEntity, updateDrivingLicenseReq);
        customerEntity.setDrivingLicenseEntity(drivingLicenseEntity);//customer a, güncellenen ehliyeti set ediyoruz.
        this.customerEntityService.update(customerEntity);//customer ı güncelliyoruz.


        return this.drivingLicenseEntityService.update(drivingLicenseEntity).convertToDTO();
    }

    @Override
    public DrivingLicenseDTO getDrivingLicense(GetDrivingLicenseReq getDrivingLicenseReq) {
        CustomerEntity customerEntity = this.customerEntityService.getById(getDrivingLicenseReq.customerId());
        return this.drivingLicenseEntityService.getById(customerEntity.getDrivingLicenseEntity().getId()).convertToDTO();

    }

}
