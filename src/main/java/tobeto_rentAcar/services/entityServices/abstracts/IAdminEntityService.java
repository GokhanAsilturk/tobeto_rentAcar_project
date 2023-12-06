package tobeto_rentAcar.services.entityServices.abstracts;

import tobeto_rentAcar.data.models.AdminEntity;

import java.util.List;

public interface IAdminEntityService {

    AdminEntity save(AdminEntity adminEntity);

    AdminEntity getById(int id);

    AdminEntity getByEmailAddress(String emailAddress);

    List<AdminEntity> getAll();

    List<AdminEntity> getAllByIsDeletedFalse();

    List<AdminEntity> getAllByIsDeletedTrue();

    AdminEntity update(AdminEntity adminEntity) throws Exception;

    void softDelete(AdminEntity adminEntity) throws Exception;

    void delete(AdminEntity adminEntity) throws Exception;

}

