package tobeto_rentAcar.services.entityServices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.entities.EmployerEntity;
import tobeto_rentAcar.dataAccess.EmployerRepository;
import tobeto_rentAcar.services.entityServices.abstracts.IEmployerEntityService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployerEntityService implements IEmployerEntityService {

    private final EmployerRepository employerRepository;

    @Override
    public EmployerEntity save(EmployerEntity employerEntity) {
        return this.employerRepository.save(employerEntity) ;
    }

    @Override
    public EmployerEntity getById(int id) {
        return this.employerRepository.findById(id).orElseThrow();
    }

    @Override
    public List<EmployerEntity> getAll() {
        return this.employerRepository.findAll();
    }

    @Override
    public EmployerEntity update(EmployerEntity employerEntity) {
        return this.save(employerEntity);
    }

    @Override
    public void delete(EmployerEntity employerEntity) {
    this.employerRepository.delete(employerEntity);
    }
}
