package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.models.vehicleEntites.CarEntity;

import java.util.List;

public interface ICustomerEntityService {

    CustomerEntity save(CustomerEntity customerEntity);

    CustomerEntity getById(int id);

    CustomerEntity getByEmailAddress(String emailAddress);

    List<CustomerEntity> getAll();

    List<CustomerEntity> getAllByIsDeletedFalse();
    List<CustomerEntity> getAllByIsDeletedTrue();
    CustomerEntity update(CustomerEntity customerEntity) throws Exception;

    void softDelete(CustomerEntity customerEntity) throws Exception;

    void delete(CustomerEntity customerEntity);

}
