package tobeto_rentAcar.data.requests.customerRequests;


import tobeto_rentAcar.data.models.BaseEntities.types.UserType;
import tobeto_rentAcar.data.models.CustomerEntity;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.AddDrivingLicenseReq;

public record AddCustomerReq(String name,
                             String surname,
                             String emailAddress,
                             String password,
                             AddDrivingLicenseReq addDrivingLicenseReq
) {

    public CustomerEntity convertToEntity() {
        CustomerEntity customerEntity = CustomerEntity.builder()
                .name(name.toLowerCase())
                .surname(surname.toLowerCase())
                .emailAddress(emailAddress)
                .password(password)
                .userType(UserType.CUSTOMER)
                .build();
        // önce customer oluşturulması gerektiği için oluşturup içerisine ehliyet ekliyoruz(eğer requeste eklenmişse)
        if (addDrivingLicenseReq != null) {
            customerEntity.setDrivingLicenseEntity(addDrivingLicenseReq.convertToEntity(customerEntity));
        }
        return customerEntity;
    }
}
