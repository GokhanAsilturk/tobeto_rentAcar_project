package tobeto_rentAcar.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.DTO.AdminDTO;
import tobeto_rentAcar.data.requests.adminRequests.AddAdminReq;
import tobeto_rentAcar.services.entityServices.AdminEntityService;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminEntityService adminEntityService;

    public AdminDTO add(AddAdminReq addAdminReq) {
        return this.adminEntityService.save(addAdminReq.convertToEntity()).convertToDTO();
    }

}
