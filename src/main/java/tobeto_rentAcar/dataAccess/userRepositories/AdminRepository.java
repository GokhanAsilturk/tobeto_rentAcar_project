package tobeto_rentAcar.dataAccess.userRepositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tobeto_rentAcar.data.models.AdminEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    Optional<AdminEntity> findByEmailAddress(String emailAddress);
    Optional<List<AdminEntity>> findAllByIsDeletedFalse();
    Optional<List<AdminEntity>> findAllByIsDeletedTrue();



}
