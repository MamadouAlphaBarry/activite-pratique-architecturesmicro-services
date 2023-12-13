package enset.sid.customerservice.exceptions;

public class CustomerNotException extends  Exception{
    public CustomerNotException() {
    }

    public CustomerNotException(String message) {
        super(message);
    }
}
