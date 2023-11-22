package tobeto_rentAcar.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionType {

    GENERIC_EXCEPTION(1, "Unkown Error!"),

    //DATA NOT FOUND Types:
    USER_DATA_NOT_FOUND(1001, "User Not Found!"),
    USER_LIST_NOT_FOUND(1002, "User List is Empty!"),

    CUSTOMER_DATA_NOT_FOUND(1003, "Customer Not Found!"),
    CUSTOMER_LIST_NOT_FOUND(1004, "Customer List is Empty!"),

    ADMIN_DATA_NOT_FOUND(1005, "Admin Not Found!"),
    ADMIN_LIST_NOT_FOUND(1006, "Admin List is Empty!"),

    VEHICLE_DATA_NOT_FOUND(1007, "Book Not Found!"),
    VEHICLE_LIST_NOT_FOUND(1008, "Book List is Empty!"),

    DRIVING_LICENSE_NOT_FOUND(1009, "Driving License Not Found!"),
    DRIVING_LICENSE_LIST_NOT_FOUND(1010, "Driving License List Not Found!");

    //------------------------------------------------------------------

    private final Integer errorCode;
    private final String message;

}
