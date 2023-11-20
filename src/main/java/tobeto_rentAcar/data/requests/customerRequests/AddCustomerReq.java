package tobeto_rentAcar.data.requests.customerRequests;


import tobeto_rentAcar.data.models.BaseEntities.types.UserType;
import tobeto_rentAcar.data.models.CustomerEntity;

public record AddCustomerReq(String name,
                             String surname,
                             String emailAddress,
                             String password
            ) {

    public CustomerEntity convertToEntity() {
    //TODO ehliyeti eklemek için service işlem yapılacak
        return CustomerEntity.builder()
                .name(name.toLowerCase())
                .surname(surname)
                .emailAddress(emailAddress.toLowerCase())
                .password(password)
                .userType(UserType.CUSTOMER)
                .build();
    }
}
