package tobeto_rentAcar.data.requests.adminRequests;

import tobeto_rentAcar.data.models.AdminEntity;
import tobeto_rentAcar.data.models.BaseEntities.types.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record AddAdminReq(
        @NotBlank()
        @Size(min = 2, max = 30)
        String name,
        @NotBlank()
        @Email
        String emailAddress,
        @NotBlank()
        @Size(min = 2, max = 30)
        String surname,
        double salary,
        @NotBlank()
        String password) {


    public AdminEntity convertToEntity() {
        return AdminEntity.builder()
                .userType(UserType.ADMIN)
                .name(name)
                .surname(surname)
                .emailAddress(emailAddress)
                .password(password)
                .salary(salary)
                .build();
    }
}
