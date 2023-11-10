package tobeto_rentAcar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.responses.TCResponse;
import tobeto_rentAcar.services.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<TCResponse<?>> addCustomer(@RequestBody AddCustomerReq addCustomerReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.add(addCustomerReq))
                .message("Müşteri eklendi")
                .build()
        );
    }

    @GetMapping("/getCustomer")ResponseEntity<TCResponse<?>> getCustomer(@RequestBody GetCustomerByIdReq getCustomerByIdReq){
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getById(getCustomerByIdReq))
                .message("Müşteri getirildi")
                .build()
        );
    }

}
