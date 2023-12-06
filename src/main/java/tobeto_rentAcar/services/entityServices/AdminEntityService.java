package tobeto_rentAcar.services.entityServices;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.models.AdminEntity;
import tobeto_rentAcar.dataAccess.userRepositories.AdminRepository;
import tobeto_rentAcar.exception.DataNotFoundException;
import tobeto_rentAcar.exception.ExceptionType;
import tobeto_rentAcar.services.entityServices.abstracts.IAdminEntityService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminEntityService implements IAdminEntityService {

    private final AdminRepository adminRepository;

    @Override
    public AdminEntity save(AdminEntity adminEntity) {
        return this.adminRepository.save(adminEntity);
    }

    @Override
    public AdminEntity getById(int id) {
        return this.adminRepository.findById(id).orElseThrow(()
                -> new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "Admin not found! :)"));
    }

    @Override
    public AdminEntity getByEmailAddress(String emailAddress) {
        return this.adminRepository.findByEmailAddress(emailAddress)
                .orElseThrow((() -> new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "Admin not found! :)")));
    }

    @Override
    public List<AdminEntity> getAll() {
        return this.adminRepository.findAll();
    }

    @Override
    public List<AdminEntity> getAllByIsDeletedFalse() {
        return this.adminRepository.findAllByIsDeletedFalse()
                .orElseThrow((() -> new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "Admin List is Empty! :)")));
    }

    @Override
    public List<AdminEntity> getAllByIsDeletedTrue() {
        return this.adminRepository.findAllByIsDeletedTrue()
                .orElseThrow((() -> new DataNotFoundException(ExceptionType.USER_DATA_NOT_FOUND, "Admin List is Empty! :)")));
    }

    @Override
    public AdminEntity update(AdminEntity adminEntity) throws Exception {
        return this.save(adminEntity);
    }

    @Override
    public void softDelete(AdminEntity adminEntity) throws Exception {
    adminEntity.setDeleted(true);
    this.save(adminEntity);
    }

    @Override
    public void delete(AdminEntity adminEntity) throws Exception {
    this.adminRepository.delete(adminEntity);
    }
}
