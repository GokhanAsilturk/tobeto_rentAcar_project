package tobeto_rentAcar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByEmailReq;
import tobeto_rentAcar.data.requests.customerRequests.GetCustomerByIdReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;
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

    @PostMapping("/add/customer")
    public ResponseEntity<TCResponse<?>> addCustomer(@RequestBody AddCustomerReq addCustomerReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.add(addCustomerReq))
                .message("Müşteri eklendi")
                .build()
        );
    }

    @GetMapping("/get/customer/byId")
    ResponseEntity<TCResponse<?>> getCustomerById(@RequestBody GetCustomerByIdReq getCustomerByIdReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getById(getCustomerByIdReq))
                .message("Müşteri getirildi")
                .build()
        );
    }

    @GetMapping("/get/customer/byEmailAddress")
    ResponseEntity<TCResponse<?>> getCustomerByEmailAddress(@RequestBody GetCustomerByEmailReq getCustomerByEmailReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getByEmailAddress(getCustomerByEmailReq))
                .message("Müşteri getirildi")
                .build()
        );
    }

    @GetMapping("/getAll/customer")
    ResponseEntity<TCResponse<?>> getAllCustomers() {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getAll())
                .message("Müşteriler getirildi")
                .build()
        );
    }

    @PutMapping("/update/customer")
    ResponseEntity<TCResponse<?>> updateCustomer(@RequestBody UpdateCustomerReq updateCustomerReq) throws Exception {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.update(updateCustomerReq))
                .message("Müşteri güncellendi")
                .build()
        );
    }

    @DeleteMapping("/delete/customer")
    ResponseEntity<TCResponse<?>> deleteCustomer(@RequestBody DeleteUserReq deleteUserReq) throws Exception {

        this.customerService.delete(deleteUserReq);
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .message("Müşteri silindi: " + deleteUserReq.emailAddress())
                .build()
        );
    }


}
