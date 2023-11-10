package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.entities.CustomerEntity;

import java.util.List;

public interface ICustomerEntityService {

    CustomerEntity save(CustomerEntity customerEntity);

    CustomerEntity getById(int id);

    CustomerEntity getByEmailAddress(String emailAddress);

    List<CustomerEntity> getAll();

    CustomerEntity update(CustomerEntity customerEntity);

    boolean delete(CustomerEntity customerEntity);

}
