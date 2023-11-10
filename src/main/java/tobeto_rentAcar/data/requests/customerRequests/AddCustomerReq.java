package tobeto_rentAcar.data.requests.customerRequests;


import tobeto_rentAcar.data.entities.BaseEntities.types.UserType;
import tobeto_rentAcar.data.entities.CustomerEntity;

public record AddCustomerReq(String name, String emailAddress, String password) {

    public CustomerEntity convertToEntity() {
        return CustomerEntity.builder()
                .name(name.toLowerCase())
                .emailAddress(emailAddress.toLowerCase())
                .password(password)
                .userType(UserType.EMPLOYER)
                .build();
    }
}
