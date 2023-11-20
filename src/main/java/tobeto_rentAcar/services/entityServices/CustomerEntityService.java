package tobeto_rentAcar.services.entityServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.dataAccess.CustomerRepository;
import tobeto_rentAcar.exception.DataNotFoundException;
import tobeto_rentAcar.exception.ExceptionType;
import tobeto_rentAcar.services.entityServices.abstracts.ICustomerEntityService;

import java.util.List;

@Service
public class CustomerEntityService implements ICustomerEntityService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerEntityService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return this.customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getById(int id) {
        return this.customerRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() ->
                new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "User Not Found! :)"));
    }

    @Override
    public CustomerEntity getByEmailAddress(String emailAddress) {
        return this.customerRepository.findByEmailAddress(emailAddress.toLowerCase())
                .orElseThrow(() ->
                        new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "User Not Found! :)"));
    }

    @Override
    public List<CustomerEntity> getAll() {
        return this.customerRepository.findAllByIsDeletedFalse().orElseThrow(() ->
                new DataNotFoundException(ExceptionType.USER_LIST_NOT_FOUND, "User List is Empty! :)"));
    }


    @Override
    public CustomerEntity update(CustomerEntity customerEntity) throws Exception {
        return this.save(customerEntity);
    }

    @Override
    public void softDelete(CustomerEntity customerEntity) throws Exception {

        try {
            customerEntity.setDeleted(true);
            this.customerRepository.save(customerEntity);
        } catch (Exception e) {
            throw new Exception();
        }

    }


}
