package tobeto_rentAcar.services.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.entities.CustomerEntity;
import tobeto_rentAcar.dataAccess.CustomerRepository;
import tobeto_rentAcar.services.entityServices.abstracts.ICustomerEntityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerEntityService implements ICustomerEntityService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return this.customerRepository.save(customerEntity);
    }

    @Override
    public CustomerEntity getById(int id) {
        return this.customerRepository.findById(id).orElseThrow();
    }

    @Override
    public CustomerEntity getByEmailAddress(String emailAddress) {
        return this.customerRepository.findByEmailAddress(emailAddress.toLowerCase());
    }

    @Override
    public List<CustomerEntity> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public CustomerEntity update(CustomerEntity customerEntity) {
        return this.save(customerEntity);
    }

    @Override
    public boolean delete(CustomerEntity customerEntity) {

        try {
            this.customerRepository.delete(customerEntity);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
