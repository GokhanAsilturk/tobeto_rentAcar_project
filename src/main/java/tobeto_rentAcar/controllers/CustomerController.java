package tobeto_rentAcar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tobeto_rentAcar.data.requests.commonRequests.userCommonRequests.DeleteUserReq;
import tobeto_rentAcar.data.requests.customerRequests.AddCustomerReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.AddDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.GetDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.DrivingLicenseRequests.UpdateDrivingLicenseReq;
import tobeto_rentAcar.data.requests.customerRequests.UpdateCustomerReq;
import tobeto_rentAcar.data.responses.TCResponse;
import tobeto_rentAcar.services.CustomerService;
import tobeto_rentAcar.services.abstracts.ICustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final ICustomerService customerService;

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

    @GetMapping("/get/customer/byId{id}")
    ResponseEntity<TCResponse<?>> getCustomerById(@RequestParam int id) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getById(id))
                .message("Müşteri getirildi")
                .build()
        );
    }

    @GetMapping("/get/customer/byEmailAddress{emailAddress}")
    ResponseEntity<TCResponse<?>> getCustomerByEmailAddress(@RequestParam String emailAddress) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getByEmailAddress(emailAddress))
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

    @PostMapping("/add/drivingLicense")
    public ResponseEntity<TCResponse<?>> addDrivingLicense(@RequestBody AddDrivingLicenseReq addDrivingLicenseReq) throws Exception {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.addDrivingLicense(addDrivingLicenseReq))
                .message("Ehliyet eklendi")
                .build()
        );
    }

    @PutMapping("/update/drivingLicense")
    ResponseEntity<TCResponse<?>> updateDrivingLicense(@RequestBody UpdateDrivingLicenseReq updateDrivingLicenseReq) throws Exception {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.updateDrivingLicense(updateDrivingLicenseReq))
                .message("Ehliyet güncellendi")
                .build()
        );
    }

    @GetMapping("/get/drivingLicense")
    ResponseEntity<TCResponse<?>> getdrivingLicense(@RequestBody GetDrivingLicenseReq getDrivingLicenseReq) {
        return ResponseEntity.ok(TCResponse.builder()
                .isSuccess(true)
                .response(this.customerService.getDrivingLicense(getDrivingLicenseReq))
                .message("Ehliyet getirildi")
                .build()
        );
    }

}
