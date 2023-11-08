package tobeto_rentAcar.services.abstracts;

import tobeto_rentAcar.data.DTO.EmployerDTO;
import tobeto_rentAcar.data.requests.AddEmployerReq;

public interface IEmployerService {
    EmployerDTO add(AddEmployerReq addEmployerReq);
}
