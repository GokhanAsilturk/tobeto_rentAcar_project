package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.entities.EmployerEntity;

import java.util.List;

public interface IEmployerEntityService {

    EmployerEntity save(EmployerEntity employerEntity);

    EmployerEntity getById(int id);

    List<EmployerEntity> getAll();

    EmployerEntity update(EmployerEntity employerEntity);

    void delete(EmployerEntity employerEntity);
}
