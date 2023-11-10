package tobeto_rentAcar.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.DTO.CustomerDTO;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByEmailReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;
import tobeto_rentAcar.services.abstracts.ICustomerService;
import tobeto_rentAcar.services.entityServices.CustomerEntityService;

import java.lang.reflect.Field;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerEntityService customerEntityService;

    //TODO add işleminin bütün implementasyonları bitti. customer üzerinden ilerliyorum
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
        Field[] customerEntityFields = CustomerEntity.class.getFields(); // fieldların listesini alıyoruz.
        Field[] customerReqFields = UpdateCustomerReq.class.getFields();

        for (Field entityField : customerEntityFields) { //bütün entity fieldlarını gez
            entityField.setAccessible(true); // Erişim izinlerini geçerli hale getir.
            for (Field requestField : customerReqFields) {
                requestField.setAccessible(true);
                if (entityField.getName().equals(requestField.getName())//entity field ismi ile request field ismi eşleşiyorsa,
                        && requestField.getBoolean(updateCustomerReq)) {//request fieldının value su boş değil ise,
                    entityField.set(customerEntity, requestField.get(updateCustomerReq)); //customerEntity nesnemize set ediyoruz.
                }
            }
        }


        return this.customerEntityService.update(customerEntity).convertToDto();
    }

    @Override
    public void delete(DeleteUserReq deleteUserReq) throws Exception {
//TODO burası hata verebilir. postman üzerinden test edilmeli.

        this.customerEntityService.softDelete(customerEntityService.getById(deleteUserReq.id()));

//        try {
//            customerEntityService.delete(customerEntityService.getById(deleteUserReq.id()));
//        } catch (Exception e) {
//            customerEntityService.delete(customerEntityService.getByEmailAddress(deleteUserReq.emailAddress()));
//        }
//
//        if (customerEntityService.softDelete(customerEntityService.getById(deleteUserReq.id()))
//                || customerEntityService.softDelete(customerEntityService.getByEmailAddress(deleteUserReq.emailAddress()))) {
//
//        } else {
//            throw new NullPointerException("bulunamadı");
//        }


    }

}
