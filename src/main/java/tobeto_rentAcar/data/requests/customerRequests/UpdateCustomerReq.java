package tobeto_rentAcar.data.requests.customerRequests;

import tobeto_rentAcar.data.DTO.CustomerDTO;

//customer dto olarak request alıp, doldurulan alanları entity sınıfına setleyerek update edeceğiz.
public record UpdateCustomerReq(CustomerDTO customerDTO) {
}
