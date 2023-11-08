package tobeto_rentAcar.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tobeto_rentAcar.data.DTO.EmployerDTO;
import tobeto_rentAcar.data.requests.AddEmployerReq;
import tobeto_rentAcar.services.abstracts.IEmployerService;
import tobeto_rentAcar.services.entityServices.EmployerEntityService;

@Service
@RequiredArgsConstructor
public class EmployerService implements IEmployerService {

private final EmployerEntityService employerEntityService;

//TODO add işleminin bütün implementasyonları bitti. employer üzerinden ilerliyorum
    @Override
    public EmployerDTO add(AddEmployerReq addEmployerReq) {
        return this.employerEntityService.save(addEmployerReq.convertToEntity()).convertToDto();
    }
}
