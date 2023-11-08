package tobeto_rentAcar.data.requests;

import tobeto_rentAcar.data.entities.BaseEntities.types.UserType;
import tobeto_rentAcar.data.entities.EmployerEntity;

public record AddEmployerReq(String name, String emailAddress, String password) {

    public EmployerEntity convertToEntity(){
        return EmployerEntity.builder()
                .name(name)
                .emailAddress(emailAddress)
                .password(password)
                .userType(UserType.EMPLOYER)
                .build();
    }
}
