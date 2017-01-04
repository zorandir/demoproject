package sample.project.domain.customer;

import sample.project.DomainEvent;

/**
 * Created by zorandir on 03/01/17.
 */
public class CustomerCreatedEvent implements DomainEvent {
    Customer customer;
    private Exception exception;

    public CustomerCreatedEvent(Customer customer){
        this.customer = customer;
    }

    public CustomerCreatedEvent(Exception exception){
        this.exception = exception;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Exception getException() {
        return exception;
    }
}
